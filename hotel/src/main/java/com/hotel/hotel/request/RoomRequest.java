package com.hotel.hotel.request;

public class RoomRequest {
    private String roomNumber;
    private int floor;
    private int state;
    private int roomTypeId;
    public RoomRequest() 
    {

    } 
    public RoomRequest(String roomNumber, int floor, int state, int roomTypeId) 
    {
        this.roomNumber=roomNumber;
        this.floor=floor;
        this.state=state;
        this.roomTypeId=roomTypeId;
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


}
