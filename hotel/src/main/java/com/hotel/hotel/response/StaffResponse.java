package com.hotel.hotel.response;

import java.sql.Date;

import com.hotel.hotel.model.Staff;

public class StaffResponse {
    private int id;
    private String citizenId; 
    private String name;
    private String phone;
    private String email;
    private Date dob;
    private String gender;
    private String address;
    private Date createdDate;
    private String staffTypeText;

    public StaffResponse() 
    {

    }
    public StaffResponse(Staff staff) 
    {
        this.id=staff.getId();
        this.citizenId=staff.getCitizenId();
        this.name=staff.getName();
        this.phone=staff.getPhone();
        this.email=staff.getEmail();
        this.dob=staff.getDob();
        this.gender=staff.getGender();
        this.address=staff.getAddress();
        this.createdDate=staff.getCreatedDate();
        this.staffTypeText=staff.getStaffType().getStaffTypeText();
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
    public Date getCreatedDate() 
    {
        return this.createdDate;
    }
    public String getStaffTypeText()
    {
        return this.staffTypeText;
    }
}
