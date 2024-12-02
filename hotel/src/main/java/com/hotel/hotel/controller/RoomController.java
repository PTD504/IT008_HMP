package com.hotel.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.response.RoomResponse;
import com.hotel.hotel.service.RoomService;

@RestController
public class RoomController { 
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms/") 
    public ResponseEntity<List<RoomResponse>> getAllRoom() 
    {
        return roomService.listAllRoom();
    }

}
