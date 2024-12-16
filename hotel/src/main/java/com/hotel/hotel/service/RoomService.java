package com.hotel.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.Room;
import com.hotel.hotel.model.RoomType;
import com.hotel.hotel.repository.RoomRepository;
import com.hotel.hotel.repository.RoomTypeRepository;
import com.hotel.hotel.request.RoomRequest;
import com.hotel.hotel.response.RoomResponse;

@Service
public class RoomService { 
    @Autowired
    private RoomRepository roomRepo;
    @Autowired
    private RoomTypeRepository roomTypeRepo;

    public ResponseEntity<List<RoomResponse>> listAllRoom() 
    {
        List<RoomResponse> listRes = new ArrayList<>();
        List<Room> listRoom= roomRepo.findAll();
        for(int i=0;i<listRoom.size();i++) 
        {
            if(listRoom.get(i).getUsable()) {
            listRes.add(new RoomResponse(listRoom.get(i)));
            }
        }
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    }
    public ResponseEntity<Room> createNewRoom(RoomRequest request) 
    {
        RoomType roomType= roomTypeRepo.findById(request.getRoomTypeId()).orElse(null);
        if(roomType==null)
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } 
        Room room = new Room(request.getRoomNumber(), request.getFloor(), request.getState(), roomType);
        roomRepo.save(room);
        return new ResponseEntity<>(room, HttpStatus.OK);
    } 
    public ResponseEntity<Room> updateRoom(int id, RoomRequest request) 
    {
        Room room = roomRepo.findById(id).orElse(null);
        if(room==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } 
        RoomType roomType= roomTypeRepo.findById(request.getRoomTypeId()).orElse(null);
        if(roomType==null)
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } 
        room.setRoomNumber(request.getRoomNumber());
        room.setFloor(request.getFloor());
        room.setState(request.getState()); 
        room.setRoomType(roomType);
        roomRepo.save(room);
        return new ResponseEntity<>(room, HttpStatus.OK);

    } 
    public ResponseEntity<String> deleteRoom(int id) 
    {
        Room room = roomRepo.findById(id).orElse(null);
        if(room==null) 
        {
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
        } 
        room.setUsable(false);
        roomRepo.save(room);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
