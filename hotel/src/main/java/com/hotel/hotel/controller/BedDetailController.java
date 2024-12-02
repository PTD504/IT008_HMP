package com.hotel.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.response.BedDetailResponse;
import com.hotel.hotel.service.BedDetailService;

@RestController
public class BedDetailController {
    @Autowired
    private BedDetailService bedDetailService;

    @GetMapping("/bed-details") 
    public ResponseEntity<List<BedDetailResponse>> getAllBedDetail() 
    {
        return bedDetailService.getAllBedDetail();
    }

}
