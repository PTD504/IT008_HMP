package com.hotel.hotel.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.experimental.FieldNameConstants;
@Entity
@FieldNameConstants
@Table(name="ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="ID", columnDefinition = "INT")
    private int id; 

    @Column(name="ROOMNUMBER", columnDefinition = "VARCHAR(100)")
    private String roomNumber;

    @Column(name="FLOOR", columnDefinition = "INT") 
    private int floor;

    @Column(name="STATE", columnDefinition = "INT")
    private int state;

    @ManyToOne
    @JoinColumn(name="ROOMTYPEID", columnDefinition = "INT", referencedColumnName = "ID") 
    private RoomType roomType; 
    @Column(name="USABLE", columnDefinition = "BOOLEAN") 
    private Boolean usable;

    public Room() 
    {

    } 
    public Room(String roomNumber, int floor, int state, RoomType roomType) 
    {
        
        this.roomNumber=roomNumber;
        this.floor=floor;
        this.state=state;
        this.roomType=roomType; 
        this.usable=true; 
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
    public RoomType getRoomType() 
    {
        return this.roomType;
    }

    public void setRoomTypeText(String roomNumber) 
    { 
        this.roomNumber=roomNumber;
    } 
    public void setFloor(int floor) 
    {
        this.floor=floor;
    } 
    public void setState(int state) 
    {
        this.state=state;
    } 
    public void setRoomType(RoomType roomType) 
    {
        this.roomType=roomType;
    } 
    public boolean getUsable() 
    {
        return this.usable;
    } 
    public void setUsable(boolean usable) 
    {
        this.usable=usable;
    } 
    public void setRoomNumber(String roomNumber) 
    {
        this.roomNumber=roomNumber;
    }

}
