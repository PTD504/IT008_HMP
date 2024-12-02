package com.hotel.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.Guest;
import com.hotel.hotel.repository.GuestRepository;
import com.hotel.hotel.response.GuestResponse;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepo;

    public ResponseEntity<List<GuestResponse>> getAllGuest() 
    { 
        List<GuestResponse> listRes= new ArrayList<>();
        List<Guest> listGuest = guestRepo.findAll();
        for(int i=0;i<listGuest.size();i++) 
        {
            listRes.add(new GuestResponse(listGuest.get(i)));
        }
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    }

}
