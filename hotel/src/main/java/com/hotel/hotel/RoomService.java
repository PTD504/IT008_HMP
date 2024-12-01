package com.hotel.hotel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.Room;
import com.hotel.hotel.repository.RoomRepository;
import com.hotel.hotel.response.RoomResponse;

@Service
public class RoomService { 
    @Autowired
    private RoomRepository roomRepo;

    public ResponseEntity<List<RoomResponse>> listAllRoom() 
    {
        List<RoomResponse> listRes = new ArrayList<>();
        List<Room> listRoom= roomRepo.findAll();
        for(int i=0;i<listRoom.size();i++) 
        {
            listRes.add(new RoomResponse(listRoom.get(i)));
        }
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    }

}
