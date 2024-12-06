package com.hotel.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.BedDetail;
import com.hotel.hotel.model.RoomType;
import com.hotel.hotel.repository.BedDetailRepository;
import com.hotel.hotel.repository.RoomTypeRepository;
import com.hotel.hotel.request.RoomTypeRequest;
import com.hotel.hotel.response.RoomTypesResponse;

@Service
public class RoomTypesService {
    @Autowired
    private RoomTypeRepository roomTypeRepo;
    @Autowired
    private BedDetailRepository bedDetailRepo;

    public ResponseEntity<List<RoomTypesResponse>> getAllRoomTypes() 
    {
        List<RoomTypesResponse> listRes= new ArrayList<>();
        List<RoomType> listRoomType= roomTypeRepo.findAll();
        for(int i=0;i<listRoomType.size();i++) 
        {
            if(listRoomType.get(i).getUsable()) {
            listRes.add(new RoomTypesResponse(listRoomType.get(i)));
            }

        }
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    }
    public ResponseEntity<RoomType> createRoomType(RoomTypeRequest request) 
    { 
        BedDetail bedDetail = bedDetailRepo.findById(request.getBedDetailId()).orElse(null);
        if(bedDetail==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }  
        RoomType roomType = new RoomType(request.getRoomTypeText(), request.getSize(), request.getPrice(), bedDetail);
        roomTypeRepo.save(roomType);
        return new ResponseEntity<>(roomType, HttpStatus.OK);
    } 
    public ResponseEntity<RoomType> updateRoomType(int id, RoomTypeRequest request) 
    {
        RoomType roomType= roomTypeRepo.findById(id).orElse(null);
        if(roomType==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        
        BedDetail bedDetail = bedDetailRepo.findById(request.getBedDetailId()).orElse(null);
        if(bedDetail==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } 
        roomType.setRoomTypeText(request.getRoomTypeText());
        roomType.setPrice(request.getPrice());
        roomType.setSize(request.getSize()); 
        roomType.setBedDetail(bedDetail);
        roomTypeRepo.save(roomType);
        return new ResponseEntity<>(roomType, HttpStatus.OK);

    } 
    public ResponseEntity<String> deleteRoomType(int id) 
    {
        RoomType roomType= roomTypeRepo.findById(id).orElse(null);
        if(roomType==null) 
        {
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
        } 
        roomType.setUsable(false); 
        roomTypeRepo.save(roomType);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
