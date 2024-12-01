package com.hotel.hotel.response;

import com.hotel.hotel.model.Room;

public class RoomResponse {
    private int id;
    private String roomNumber;
    private int floor;
    private int state;
    private int roomTypeId;
    private String roomTypeText;
    private int size;
    private int price;
    private int bedDetailId;
    private String bedDetailText;
    public RoomResponse()
    {

    } 
    public RoomResponse(Room room)
    {
        this.id=room.getId();
        this.roomNumber= room.getRoomNumber();
        this.floor=room.getFloor();
        this.state=room.getState();
        this.roomTypeId=room.getRoomType().getId();
        this.roomTypeText= room.getRoomType().getRoomTypeText();
        this.size= room.getRoomType().getSize();
        this.price = room.getRoomType().getPrice();
        this.bedDetailId=room.getRoomType().getBedDetail().getId();
        this.bedDetailText=room.getRoomType().getBedDetail().getBedDetailText(); 
    } 

    public int getId() 
    {
        return this.id;
    } 
    public String getRoomNumber() 
    {
        return this.roomNumber;
    } 
    public int getFloor() 
    {
        return this.floor;
    }
    public int getState() 
    {
        return this.state;
    } 
    public int getRoomTypeId()
    {
        return this.roomTypeId;
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
    public String getBedDetailText() 
    {
        return this.bedDetailText;  
    }

}
