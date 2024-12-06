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

import com.hotel.hotel.model.RoomType;

import com.hotel.hotel.request.RoomTypeRequest;
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
    @PostMapping("/room-types/create") 
    public ResponseEntity<RoomType> createRoomType(@RequestBody RoomTypeRequest request) 
    {
        return roomTypesService.createRoomType(request);
    } 
    @PutMapping("/room-types/update/{id}") 
    public ResponseEntity<RoomType> updateRoomType(@RequestBody RoomTypeRequest request, @PathVariable int id) 
    {
        return roomTypesService.updateRoomType(id, request);
    } 
    @DeleteMapping("/room-types/delete/{id}")
    public ResponseEntity<String> deleteRoomType(@PathVariable int id) 
    {
        return roomTypesService.deleteRoomType(id);
    }    
}
