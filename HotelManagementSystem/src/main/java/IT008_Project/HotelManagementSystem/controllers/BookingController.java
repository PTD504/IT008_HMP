package IT008_Project.HotelManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import IT008_Project.HotelManagementSystem.dtos.BookingsCreationRequest;
import IT008_Project.HotelManagementSystem.dtos.Request;
import IT008_Project.HotelManagementSystem.response.BookingResponse;
import IT008_Project.HotelManagementSystem.response.Response;
import IT008_Project.HotelManagementSystem.services.BookingsService;

@RestController
public class BookingController {  
    @Autowired
    private BookingsService bookingService;
    @PostMapping("/new/booking") 
    public ResponseEntity<Response> newBooking(@RequestBody Request request) 
    { 
        if(request.getRole()<0) 
        { 
            return new ResponseEntity<>(new Response(null,"Ban khong co quyen truy cap chuc nang nay"), HttpStatus.UNAUTHORIZED);
        } 

        if(request.getRequestData() instanceof BookingsCreationRequest) 
        { 

            return bookingService.newBooking((BookingsCreationRequest)request.getRequestData());
        }
        else 
        {
            return new ResponseEntity<>(new Response(null, "Thong tin sai"), HttpStatus.BAD_REQUEST);
        }
    }

}
