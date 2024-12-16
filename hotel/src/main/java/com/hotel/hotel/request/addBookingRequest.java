package com.hotel.hotel.request;

import java.sql.Date;

public class addBookingRequest { 
    private Date checkinDate;
    private Date checkoutDate;
    private String roomId;
    private String citizenId;
    private String guestName;
    private String phone;
    private String email;
    private Date dob;
    private String gender;
    private String address; 
    private int staffId;

    public addBookingRequest() 
    {

    } 
    public addBookingRequest(Date checkinDate, Date checkoutDate, String roomId, String citizenId, String guestName, String phone, String email, Date dob, String gender, String address, int staffId) 
    {
        this.checkinDate=checkinDate;
        this.checkoutDate=checkoutDate;
        this.roomId=roomId;
        this.citizenId=citizenId;
        this.guestName=guestName;
        this.phone=phone;
        this.email=email;
        this.dob=dob;
        this.gender=gender;
        this.address=address; 
        this.staffId=staffId;
    } 
    public int getStaffId() 
    {
        return this.staffId;
    }
    public Date getCheckinDate() 
    {
        return this.checkinDate;
    } 
    public Date getCheckoutDate() 
    {
        return this.checkoutDate;
    }
    public String getRoomId() 
    {
        return this.roomId;
    } 
    public String getCitizenId() 
    {
        return this.citizenId;
    }
    public String getGuestName() 
    {
        return this.guestName;
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
