package com.hotel.hotel.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.hotel.hotel.response.Revenue;
import com.hotel.hotel.response.RevenueData;
import com.hotel.hotel.response.RevenueDetail;
import com.hotel.hotel.response.RevenueDetailData;

@Service
public class RevenueService {
    @Autowired
    private BookingRepository bookingRepo; 
    @Autowired
    private RoomTypeRepository roomTypeRepo;

    
    public List<Booking> listPaidBooking(int month, int year) 
    {
        List<Booking> listRes = new ArrayList<>();
        List<Booking> listBooking= bookingRepo.findAll();
        for(int i=0;i<listBooking.size();i++)
        {
            Date payDate= listBooking.get(i).getCheckoutDate();
            Calendar calendar= Calendar.getInstance();
            calendar.setTime(payDate);

            if(calendar.get(Calendar.MONTH)+1==month&&calendar.get(Calendar.YEAR)==year) 
            {
                listRes.add(listBooking.get(i));
            }
        } 
        return listRes;
    }

    public ResponseEntity<Revenue> revenueByYear(int year) 
    {
        Revenue revenue= new Revenue();
        for(int i=1;i<=12;i++) 
        {
            String month="Tháng "+ Integer.toString(i);
            RevenueData  revenueData= revenueByMonth(month, year);
            revenue.addRevenueData(revenueData);
        }
        return new ResponseEntity<>(revenue, HttpStatus.OK);
    } 
    public RevenueData revenueByMonth(String month, int year) 
    {
        RevenueData revenueData= new RevenueData(month,0); 
        List<RoomType> listRoomType= roomTypeRepo.findAll();
        String monthString = month.substring(6);
        Integer monthNumber= Integer.parseInt(monthString);
        List<Booking> listPaidBooking = listPaidBooking(monthNumber, year);
        List<RevenueDetailData> listDetailData= new ArrayList<>();
        for(int i=0;i<listRoomType.size();i++)
        {
            listDetailData.add(new RevenueDetailData(listRoomType.get(i).getRoomTypeText(), 0));
        } 
        for(int i=0;i<listPaidBooking.size();i++) 
        {
            for(int j=0;j<listRoomType.size();j++) 
            {
                if(listPaidBooking.get(i).getRoom().getRoomType().getId()==listRoomType.get(j).getId()) 
                {
                    System.out.println(listDetailData.get(j).getRevenue());
                    listDetailData.get(j).setRevenue(listDetailData.get(j).getRevenue()+listPaidBooking.get(i).getTotalPrice());

                }
            }
        }
        for(int i=0;i<listDetailData.size();i++) 
        {
            if(listDetailData.get(i).getRevenue()!=0) {
            revenueData.addDetail(listDetailData.get(i));
            }
        } 
        return revenueData;
    }

}
