package com.hotel.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.Booking;
import com.hotel.hotel.repository.BookingRepository;
import com.hotel.hotel.response.BookingResponse;



@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public ResponseEntity<List<BookingResponse>> getAllBookings() {
        // Gọi phương thức tùy chỉnh từ repository
        List<BookingResponse> listRes = new ArrayList<>();
        List<Booking> listBookings=bookingRepository.findAll(); 
        for(int i=0;i<listBookings.size();i++) 
        {
           listRes.add(new BookingResponse(listBookings.get(i)));
        }
        // Trả về ResponseEntity
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    }
}