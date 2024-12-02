package com.hotel.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.BedDetail;
import com.hotel.hotel.repository.BedDetailRepository;
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
            listRes.add( new BedDetailResponse(listBedDetails.get(i)));

        }
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    }
}
