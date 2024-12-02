package com.hotel.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.response.RoomTypesResponse;
import com.hotel.hotel.service.RoomTypesService;

@RestController
public class RoomTypeController {  
    @Autowired
    private RoomTypesService roomTypesService;
    @GetMapping("/room-types/")
    public ResponseEntity<List<RoomTypesResponse>> getAllRoomTypes() 
    {
        return roomTypesService.getAllRoomTypes();
    }
    
}
