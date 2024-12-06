package com.hotel.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.BedDetail;
import com.hotel.hotel.repository.BedDetailRepository;
import com.hotel.hotel.request.BedDetailCreationRequest;
import com.hotel.hotel.response.BedDetailResponse;

@Service
public class BedDetailService {
    @Autowired
    private BedDetailRepository bedDetailRepo;

    public ResponseEntity<List<BedDetailResponse>> getAllBedDetail() 
    {
        List<BedDetailResponse> listRes = new ArrayList<>();
        List<BedDetail> listBedDetails= bedDetailRepo.findAll();
        for(int i=0;i<listBedDetails.size();i++)
        {
            if(listBedDetails.get(i).getUsable()){
            listRes.add( new BedDetailResponse(listBedDetails.get(i)));
            }

        }
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    } 

    public ResponseEntity<BedDetail> createBedDetail(BedDetailCreationRequest request) 
    {
        BedDetail bedDetail= new BedDetail(request.getBedDetailText());
        bedDetailRepo.save(bedDetail);
        return new ResponseEntity<>(bedDetail, HttpStatus.OK);
    } 
    public ResponseEntity<BedDetail> updateBedDetail(int id, BedDetailCreationRequest request) 
    {
        BedDetail bedDetail= bedDetailRepo.findById(id).orElse(null);
        if(bedDetail==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } 
        bedDetail.setBedDetailText(request.getBedDetailText());
        bedDetailRepo.save(bedDetail);
        return new ResponseEntity<>(bedDetail, HttpStatus.OK);
    } 
    public ResponseEntity<String> deleteBedDetail(int id) 
    {
        BedDetail bedDetail= bedDetailRepo.findById(id).orElse(null);
        if(bedDetail==null) 
        {
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
        }
        bedDetail.setUsable(false);
        bedDetailRepo.save(bedDetail);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
    
}
