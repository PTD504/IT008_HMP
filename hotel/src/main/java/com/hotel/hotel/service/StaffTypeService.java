package com.hotel.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.Staff;
import com.hotel.hotel.model.StaffType;
import com.hotel.hotel.repository.StaffTypeRepository;
import com.hotel.hotel.request.StaffTypeRequest;

@Service
public class StaffTypeService {
    @Autowired
    private StaffTypeRepository staffTypeRepo;

    public ResponseEntity<List<StaffType>> getAllStaffType() 
    {
        List<StaffType> listStaffType = staffTypeRepo.findAll();
        List<StaffType> listRes= new ArrayList<>();
        for(int i=0;i<listStaffType.size();i++) 
        {
            if(listStaffType.get(i).getUsable()) 
            {
                listRes.add(listStaffType.get(i));
            }
        } 
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    }
    public ResponseEntity<StaffType> createStaffType(StaffTypeRequest request) 
    {
        StaffType staffType= new StaffType(request.getStaffTypeText());
        staffTypeRepo.save(staffType);
        return new ResponseEntity<>(staffType, HttpStatus.OK);
    } 
    public ResponseEntity<StaffType> updateStaffType(int id, StaffTypeRequest request) 
    {
        StaffType staffType= staffTypeRepo.findById(id).orElse(null);
        if(staffType==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } 
        staffType.setStaffTypeText(request.getStaffTypeText());
        staffTypeRepo.save(staffType);
        return new ResponseEntity<>(staffType, HttpStatus.OK);
    } 
    public ResponseEntity<String> deleteStaffType(int id) 
    {
        StaffType staffType= staffTypeRepo.findById(id).orElse(null);
        if(staffType==null) 
        {
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
        } 
        staffType.setUsable(false); 
        staffTypeRepo.save(staffType);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
