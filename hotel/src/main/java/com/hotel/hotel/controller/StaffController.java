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

import com.hotel.hotel.model.Staff;
import com.hotel.hotel.request.StaffRequest;
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
    @PostMapping("/staffs/create") 
    public ResponseEntity<Staff> createStaff(@RequestBody StaffRequest request) 
    {
        return staffService.createStaff(request);
    }

    @PutMapping("/staffs/update/{id}") 
    public ResponseEntity<Staff> updateStaff(@PathVariable int id, @RequestBody StaffRequest request) 
    {
        return staffService.updateStaff(id, request);
    }

    @DeleteMapping("/staffs/delete/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable int id)
    {
        return staffService.deleteStaff(id);
    }


}
