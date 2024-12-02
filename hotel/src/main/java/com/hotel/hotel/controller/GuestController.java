package com.hotel.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.response.GuestResponse;
import com.hotel.hotel.service.GuestService;

@RestController
public class GuestController {
    @Autowired
    private GuestService guestService;
    @GetMapping("/guests")
    public ResponseEntity<List<GuestResponse>> getAllGuest() 
    {
        return guestService.getAllGuest();
    }
    
}
