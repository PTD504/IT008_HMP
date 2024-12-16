package com.hotel.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.request.RevenueRequest;
import com.hotel.hotel.response.Revenue;
import com.hotel.hotel.service.RevenueService;

@RestController
public class RevenueController {
    @Autowired 
    private RevenueService revenueService;

    @GetMapping("/revenue/{year}") 
    public ResponseEntity<Revenue> revenueByYear(@PathVariable int year) 
    {
        return revenueService.revenueByYear(year);
    }

}
