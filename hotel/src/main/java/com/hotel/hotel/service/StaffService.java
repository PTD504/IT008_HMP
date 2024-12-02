package com.hotel.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.Staff;
import com.hotel.hotel.repository.StaffRepository;
import com.hotel.hotel.response.StaffResponse;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepo;

    public ResponseEntity<List<StaffResponse>> getAllStaff() 
    {
        List<StaffResponse> listRes = new ArrayList<>();
        List<Staff> listStaff= staffRepo.findAll();
        for(int i=0;i<listStaff.size();i++) 
        {
            listRes.add(new StaffResponse(listStaff.get(i)));
        }
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    }
}
