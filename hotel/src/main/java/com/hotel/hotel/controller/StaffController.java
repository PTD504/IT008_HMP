package com.hotel.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.response.StaffResponse;
import com.hotel.hotel.service.StaffService;

@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/staffs/") 
    public ResponseEntity<List<StaffResponse>> getAllStaff() 
    {
        return staffService.getAllStaff();
    }

}
