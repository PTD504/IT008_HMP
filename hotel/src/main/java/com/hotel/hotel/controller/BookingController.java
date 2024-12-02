package com.hotel.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.response.BookingResponse;
import com.hotel.hotel.service.BookingService;

@RestController
@RequestMapping("/bookings/")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<BookingResponse>> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
