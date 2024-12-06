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
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.model.BedDetail;
import com.hotel.hotel.request.BedDetailCreationRequest;
import com.hotel.hotel.response.BedDetailResponse;
import com.hotel.hotel.service.BedDetailService;

@RestController
public class BedDetailController {
    @Autowired
    private BedDetailService bedDetailService;

    @GetMapping("/bed-details/") 
    public ResponseEntity<List<BedDetailResponse>> getAllBedDetail() 
    {
        return bedDetailService.getAllBedDetail();
    }
    @PostMapping("/add/bed-detail/")
    public ResponseEntity<BedDetail> addBedDetail(@RequestBody BedDetailCreationRequest request) 
    {
        return bedDetailService.createBedDetail(request);
    } 
    @PutMapping("/update/bed-detail/{id}") 
    public ResponseEntity<BedDetail> updateBedDetail(@PathVariable int id, @RequestBody BedDetailCreationRequest request) 
    {
        return bedDetailService.updateBedDetail(id, request);
    }
    @DeleteMapping("/delete/bed-detail/{id}")
    public ResponseEntity<String> deleteBedDetail(@PathVariable int id) 
    {

        return bedDetailService.deleteBedDetail(id);
    }

}
