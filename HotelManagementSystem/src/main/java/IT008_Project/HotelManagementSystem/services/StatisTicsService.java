package IT008_Project.HotelManagementSystem.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import IT008_Project.HotelManagementSystem.models.Bookings;
import IT008_Project.HotelManagementSystem.models.Payment;
import IT008_Project.HotelManagementSystem.models.RoomTypes;
import IT008_Project.HotelManagementSystem.models.StatisticModel;
import IT008_Project.HotelManagementSystem.repositories.BookingsRepository;
import IT008_Project.HotelManagementSystem.repositories.PaymentRepository;
import IT008_Project.HotelManagementSystem.repositories.RoomTypesRepository;
import IT008_Project.HotelManagementSystem.response.Response;

@Service
public class StatisTicsService {
    @Autowired 
    private BookingsRepository bookingRepo; 
    @Autowired
    private RoomTypesRepository roomTypeRepo; 

    @Autowired 
    private PaymentRepository paymentRepo;

    public ResponseEntity<Response> statisticAmountGuest(int month, int year) 
    {
         
        List<RoomTypes> listRoomType = roomTypeRepo.findAll();
 
        List<StatisticModel> listRes= new ArrayList<>(); 
        for(int i=0;i<listRoomType.size();i++) 
        {

            List<Bookings> listBookingByRoomType = findBookingByRoomType(listRoomType.get(i),bookingRepo.findAll()); 
            int s=0;
            for(int j=0;j<listBookingByRoomType.size();j++) 
            { 
                Date checkinDate = listBookingByRoomType.get(j).getCheckinDate();
                if(checkinDate.getMonth()==month&&checkinDate.getYear()==year) 
                {
                    s=s+listBookingByRoomType.get(j).getRoom().getRoom_Types().getCapacity();
                }
            } 
            listRes.add(new StatisticModel(listRoomType.get(i),s));
        } 
        return new ResponseEntity<>(new Response(listRes,"Tao thong ke thanh cong"), HttpStatus.OK);
    }
    public ResponseEntity<Response> statisticIncome(int month, int year) 
    {
        List<RoomTypes> listRoomType = roomTypeRepo.findAll();
        List<StatisticModel> listRes= new ArrayList<>();  
        for(int i=0;i<listRoomType.size();i++) 
        {
            List<Payment> listPaymentByRoomType = findPaymentByRoomType(listRoomType.get(i),paymentRepo.findAll());
            int s=0;
            for(int j=0;j<listPaymentByRoomType.size();j++)
            {
                Date payDate = listPaymentByRoomType.get(i).getPayDate();
                if(payDate.getMonth()==month&&payDate.getYear()==year)
                {
                    s=s+listPaymentByRoomType.get(i).getPayAmount();
                }
            }
            listRes.add(new StatisticModel(listRoomType.get(i),s));
        } 
        return new ResponseEntity<>(new Response(listRes,"Tao thong ke thanh cong"), HttpStatus.OK);
    }
    private List<Payment> findPaymentByRoomType(RoomTypes roomType, List<Payment> listPayment) 
    {
        List<Payment> res= new ArrayList<>();
        for(int i=0;i<listPayment.size();i++) 
        {
            if(listPayment.get(i).getBooking().getRoom().getRoom_Types().getId()==roomType.getId())
            {
                res.add(listPayment.get(i));
            }
        } 
        return res;
    }  
    private List<Bookings> findBookingByRoomType(RoomTypes roomType, List<Bookings> listBooking)
    {
        List<Bookings> res= new ArrayList<>();
        for(int i=0;i<listBooking.size();i++) 
        {
            if(listBooking.get(i).getRoom().getRoom_Types().getId()==roomType.getId())
            {
                res.add(listBooking.get(i));
            } 
        } 
        return res;
    }
    
} 

