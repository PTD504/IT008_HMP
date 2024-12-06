package com.hotel.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.Staff;
import com.hotel.hotel.model.StaffType;
import com.hotel.hotel.repository.StaffRepository;
import com.hotel.hotel.repository.StaffTypeRepository;
import com.hotel.hotel.request.StaffRequest;
import com.hotel.hotel.response.StaffResponse;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepo;
    @Autowired
    private StaffTypeRepository staffTypeRepo;

    public ResponseEntity<List<StaffResponse>> getAllStaff() 
    {
        List<StaffResponse> listRes = new ArrayList<>();
        List<Staff> listStaff= staffRepo.findAll();
        for(int i=0;i<listStaff.size();i++) 
        {
            if(listStaff.get(i).getUsable()) 
            {
            listRes.add(new StaffResponse(listStaff.get(i))); 
            }
        }
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    } 
    public ResponseEntity<Staff> createStaff(StaffRequest request) 
    { 
        StaffType staffType=staffTypeRepo.findById(request.getStaffTypeId()).orElse(null);
        if(staffType==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } 
        Staff staff = new Staff(request.getCitizenId(), request.getName(), request.getPhone(), request.getEmail(), request.getDob(), request.getGender(), request.getAddress(),request.getCreatedDate(), staffType);
        staffRepo.save(staff);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }
    public ResponseEntity<Staff> updateStaff(int id,StaffRequest request) 
    { 
        Staff staff = staffRepo.findById(id).orElse(null);
        if(staff==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        StaffType staffType=staffTypeRepo.findById(request.getStaffTypeId()).orElse(null);
        if(staffType==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } 
        staff.setCitizenId(request.getCitizenId()); 
        staff.setName(request.getName()); 
        staff.setPhone(request.getPhone()); 
        staff.setAddress(request.getAddress()); 
        staff.setDob(request.getDob());
        staff.setGender(request.getGender());
        staff.setStaffType(staffType);
        staffRepo.save(staff);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }
    public ResponseEntity<String> deleteStaff(int id) 
    {
        Staff staff = staffRepo.findById(id).orElse(null);
        if(staff==null) 
        {
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
        } 
        staff.setUsable(false); 
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
