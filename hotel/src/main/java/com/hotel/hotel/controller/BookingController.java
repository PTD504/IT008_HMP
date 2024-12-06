package com.hotel.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.request.addBookingRequest;
import com.hotel.hotel.response.BookingResponse;
import com.hotel.hotel.service.BookingService;

@RestController

public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings/")
    public ResponseEntity<List<BookingResponse>> getAllBookings() {
        return bookingService.getAllBookings();
    }  
    @PostMapping("/bookings/") 
    public ResponseEntity<addBookingRequest> addBooking(@RequestBody addBookingRequest request) 
    {
        return bookingService.addBooking(request);
    } 
   

    
}
