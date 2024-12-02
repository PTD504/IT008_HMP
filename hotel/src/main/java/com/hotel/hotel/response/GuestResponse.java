package com.hotel.hotel.response;

import java.sql.Date;

import com.hotel.hotel.model.Guest;

public class GuestResponse {
    private int id;
    private String citizenId; 
    private String name;
    private String phone;
    private String email;
    private Date dob;
    private String gender;
    private String address;

    public GuestResponse()
    {

    }
    public GuestResponse(Guest guest) 
    {
        this.id=guest.getId();
        this.citizenId=guest.getCitizenId();
        this.name=guest.getName();
        this.phone=guest.getPhone();
        this.email=guest.getEmail();
        this.dob=guest.getDob();
        this.gender=guest.getGender();
        this.address=guest.getAddress();
    } 
    public int getId() 
    {
        return this.id;
    } 
    public String getCitizenId() 
    {
        return this.citizenId;
    }
    public String getName() 
    {
        return this.name;
    } 
    public String getPhone() 
    {
        return this.phone;
    }
    public String getEmail() 
    {
        return this.email;
    }
    public Date getDob() 
    {
        return this.dob;
    }
    public String getGender() 
    {
        return this.gender;
    }
    public String getAddress() 
    {
        return this.address;
    }

}
