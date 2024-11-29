package IT008_Project.HotelManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import IT008_Project.HotelManagementSystem.dtos.PaymentCreationRequest;
import IT008_Project.HotelManagementSystem.dtos.Request;
import IT008_Project.HotelManagementSystem.models.Payment;
import IT008_Project.HotelManagementSystem.response.Response;
import IT008_Project.HotelManagementSystem.services.PaymentService;

@RestController
public class PaymentController { 
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/getAll") 
    public List<Payment> getAllPayments() 
    {
        return paymentService.getAllPayment();
    } 

    @GetMapping("/payment/getById/{id}") 
    public Payment getById(@PathVariable int id) 
    {
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/payment/create") 
    public ResponseEntity<Response> createNewPayment(@RequestBody Request request) 
    {
         if(request.getRole()<0) 
        { 
            return new ResponseEntity<>(new Response(null,"Ban khong co quyen truy cap chuc nang nay"), HttpStatus.UNAUTHORIZED);
        }  
        if(request.getRequestData() instanceof PaymentCreationRequest) 
        {
            return paymentService.createPayment((PaymentCreationRequest) request.getRequestData());
        } 
        else {
            return new ResponseEntity<>(new Response(null,"Thong tin sai"), HttpStatus.BAD_REQUEST);
        }

    }
}
