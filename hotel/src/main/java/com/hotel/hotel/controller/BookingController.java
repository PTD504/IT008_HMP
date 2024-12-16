package com.hotel.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.model.Booking;
import com.hotel.hotel.request.BookingRenewalRequest;
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

    @GetMapping("/checkin/{id}") 
    public ResponseEntity<Booking> checkin(@PathVariable int id) 
    {
        return bookingService.checkIn(id);
    } 

    @GetMapping("/checkout/{id}") 
    public ResponseEntity<Booking> checkout(@PathVariable int id) 
    {
        return bookingService.checkOut(id);
    } 

    @PutMapping("/renewal/{id}") 
    public ResponseEntity<Booking> renewal(@PathVariable int id, @RequestBody BookingRenewalRequest request) 
    {
        return bookingService.renewal(id, request);
    }

    @PostMapping("/renewal/check/{id}")
    public ResponseEntity<String> checkRenewal(@PathVariable int id, @RequestBody BookingRenewalRequest request) 
    {
        return bookingService.checKValidNewCheckoutDate(id, request);
    }
    @DeleteMapping("/booking/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) 
    {
        return bookingService.deleteBooking(id);
    }   

    
}
