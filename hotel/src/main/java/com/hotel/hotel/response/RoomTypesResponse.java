package com.hotel.hotel.response;

import com.hotel.hotel.model.RoomType;

public class RoomTypesResponse { 
    private int id;
    private String roomTypeText;
    private int size;
    private int price;
    private String bedDetailText;  
    private int bedDetailId;

    public RoomTypesResponse() 
    {

    } 
    public RoomTypesResponse(RoomType roomType)
    {
        this.id=roomType.getId();
        this.roomTypeText= roomType.getRoomTypeText();
        this.size=roomType.getSize();
        this.price=roomType.getPrice();
        this.bedDetailText=roomType.getBedDetail().getBedDetailText(); 
        this.bedDetailId=roomType.getBedDetail().getId();
    }  
    public int getBedDetailId() 
    {
        return this.bedDetailId;
    }
    public int getId() 
    {
        return this.id;
    } 
    public String getRoomTypeText() 
    {
        return this.roomTypeText;
    }
    public int getSize() 
    {
        return this.size;
    }
    public int getPrice() 
    {
        return this.price;
    } 
    public String getBedDetailText() 
    {
        return this.bedDetailText;  
    }

}
