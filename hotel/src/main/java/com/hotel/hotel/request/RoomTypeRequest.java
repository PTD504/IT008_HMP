package com.hotel.hotel.request;

public class RoomTypeRequest { 
    private String roomTypeText;
    private int size;
    private int price;
    private int bedDetailId;
    public RoomTypeRequest() 
    {

    } 
    public RoomTypeRequest(String roomTypeText, int size, int price, int bedDetailId) 
    {
        this.roomTypeText=roomTypeText;
        this.size=size;
        this.price=price;
        this.bedDetailId=bedDetailId;
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
    public int getBedDetailId() 
    {
        return this.bedDetailId;
    }
}
