package IT008_Project.HotelManagementSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import IT008_Project.HotelManagementSystem.dtos.PaymentCreationRequest;
import IT008_Project.HotelManagementSystem.models.Bookings;
import IT008_Project.HotelManagementSystem.models.Employee;
import IT008_Project.HotelManagementSystem.models.Payment;
import IT008_Project.HotelManagementSystem.repositories.BookingsRepository;
import IT008_Project.HotelManagementSystem.repositories.EmployeeRepository;
import IT008_Project.HotelManagementSystem.repositories.PaymentRepository;
import IT008_Project.HotelManagementSystem.response.Response;

@Service
public class PaymentService { 
    @Autowired
    private BookingsRepository bookingsRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private PaymentRepository paymentRepo; 

    public List<Payment> getAllPayment()
    {
        return paymentRepo.findAll();
    } 
    public Payment getPaymentById(int id) 
    {
        return paymentRepo.findById(id).orElse(null);
    }

    public ResponseEntity<Response> createPayment(PaymentCreationRequest request) 
    { 
        Bookings booking= bookingsRepo.findById(request.getBookingId()).orElse(null);
        if(booking==null) 
        {
            return new ResponseEntity<>(new Response(null, "Booking khong ton tai"), HttpStatus.BAD_REQUEST);
        } 
        Employee employee = employeeRepo.findById(request.getEmployeeId()).orElse(null); 
        if(employee==null) 
        {
            return new ResponseEntity<>(new Response(null, "Nhan vien khong ton tai"), HttpStatus.BAD_REQUEST);
        } 

        int newPaymentId= paymentRepo.findAll().size()+1;
        Payment newPayment = new Payment(newPaymentId, booking,employee, request.getPayAmount(), request.getPayDate(), request.getPayMethod());
        paymentRepo.save(newPayment);
        return new ResponseEntity<>(new Response(newPayment, "Tao phieu thanh toan thanh cong"), HttpStatus.OK);

    }

}
