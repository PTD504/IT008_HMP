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

import com.hotel.hotel.model.StaffType;
import com.hotel.hotel.request.StaffTypeRequest;
import com.hotel.hotel.service.StaffTypeService;

@RestController
public class StaffTypeController { 
    @Autowired
    private StaffTypeService staffTypeService;

    @GetMapping("/staff-types/")
    public ResponseEntity<List<StaffType>> getAllStaffType() 
    {
        return staffTypeService.getAllStaffType();
    }

    @PostMapping("/staff-types/create") 
    public ResponseEntity<StaffType> createStaffType(@RequestBody StaffTypeRequest request) 
    {
        return staffTypeService.createStaffType(request);
    }

    @PutMapping("/staff-types/update/{id}")
    public ResponseEntity<StaffType> updateStaffType(@RequestBody StaffTypeRequest request, @PathVariable int id)
    {
        return staffTypeService.updateStaffType(id, request);
    } 

    @DeleteMapping("/staff-types/delete/{id}")
    public ResponseEntity<String> deleteStaffType(@PathVariable int id) 
    {
        return staffTypeService.deleteStaffType(id);
    }

}
