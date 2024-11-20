package IT008_Project.HotelManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import IT008_Project.HotelManagementSystem.dtos.BookingsCreationRequest;
import IT008_Project.HotelManagementSystem.response.BookingResponse;
import IT008_Project.HotelManagementSystem.services.BookingsService;

@RestController
public class BookingController {  
    @Autowired
    private BookingsService bookingService;
    @PostMapping("/new/booking") 
    public ResponseEntity<BookingResponse> newBooking(@RequestBody BookingsCreationRequest request) 
    { 
        return bookingService.newBooking(request);
    }

}
