package com.hotel.hotel.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.Booking;
import com.hotel.hotel.model.RoomType;
import com.hotel.hotel.repository.BookingRepository;
import com.hotel.hotel.repository.RoomTypeRepository;
import com.hotel.hotel.request.RevenueRequest;

import com.hotel.hotel.response.RevenueDetail;

@Service
public class RevenueService {
    @Autowired
    private BookingRepository bookingRepo; 
    @Autowired
    private RoomTypeRepository roomTypeRepo;

    private List<RoomType> usableRoomTypes() 
    {
        List<RoomType> listRes= new ArrayList<>();
        List<RoomType> listRoomType= roomTypeRepo.findAll();
        for(int i=0;i<listRoomType.size();i++) 
        {
            if(listRoomType.get(i).getUsable()) 
            {
                listRes.add(listRoomType.get(i));
            }
        } 
        return listRes;
    }
    public List<Booking> listPaidBooking(int month, int year) 
    {
        List<Booking> listRes = new ArrayList<>();
        List<Booking> listBooking= bookingRepo.findAll();
        for(int i=0;i<listBooking.size();i++)
        {
            Date payDate= listBooking.get(i).getCheckoutDate();

            if(payDate.getMonth()<month&&payDate.getYear()<year) 
            {
                listRes.add(listBooking.get(i));
            }
        } 
        return listRes;
    }

    public List<RevenueDetail> revenueByMonth(RevenueRequest request, List<RoomType> listRoomType) 
    {  
        
        List<RevenueDetail> listRes= new ArrayList<>();
        List<Integer> listIndex= new ArrayList<>();
        
        List<Booking> listBooking= listPaidBooking(request.getMonth(), request.getYear());
        for(int i=0;i<listRoomType.size();i++) 
        {
            listRes.add(new RevenueDetail(listRoomType.get(i).getRoomTypeText(),0));
            listIndex.add(listRoomType.get(i).getId());

        }
        for(int i=0;i<listBooking.size();i++)
        {
            int roomTypeId= listBooking.get(i).getRoom().getRoomType().getId();
            int index = listIndex.indexOf(roomTypeId);
            listRes.get(index).addTotalPrice(listBooking.get(i).getTotalPrice());
        } 
        return listRes;

    } 
    public ResponseEntity<List<List<RevenueDetail>>> revenueByYear(int year) 
    {
        List<List<RevenueDetail>> listRes= new ArrayList<>(); 
        List<RoomType> listRoomType=usableRoomTypes();
        for(int i=1;i<=12;i++) 
        {
            listRes.add(revenueByMonth(new RevenueRequest(i, year), listRoomType));
        }
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    }

}
