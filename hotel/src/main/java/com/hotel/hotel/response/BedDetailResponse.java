package com.hotel.hotel.response;

import com.hotel.hotel.model.BedDetail;

public class BedDetailResponse { 
    private int id;
    private String bedDetailText;
    public BedDetailResponse() 
    {

    } 
    public BedDetailResponse(BedDetail bedDetail) 
    {
        this.id=bedDetail.getId();
        this.bedDetailText=bedDetail.getBedDetailText();
    } 
    public int getId() 
    {
        return this.id;
    } 
    public String getBedDetailText() 
    {
        return this.bedDetailText;
    }

}
