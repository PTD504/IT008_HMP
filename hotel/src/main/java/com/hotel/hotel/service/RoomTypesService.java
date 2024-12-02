package com.hotel.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.RoomType;
import com.hotel.hotel.repository.RoomTypeRepository;
import com.hotel.hotel.response.RoomTypesResponse;

@Service
public class RoomTypesService {
    @Autowired
    private RoomTypeRepository roomTypeRepo;

    public ResponseEntity<List<RoomTypesResponse>> getAllRoomTypes() 
    {
        List<RoomTypesResponse> listRes= new ArrayList<>();
        List<RoomType> listRoomType= roomTypeRepo.findAll();
        for(int i=0;i<listRoomType.size();i++) 
        {
            listRes.add(new RoomTypesResponse(listRoomType.get(i)));
        }
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    }

}
