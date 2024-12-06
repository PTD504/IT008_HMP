package com.hotel.hotel.request;

import java.sql.Date;



public class StaffRequest {  
    private String citizenId;
    private String name;
    private String phone;
    private String email;
    private Date dob;
    private String gender;
    private String address;
    private Date createdDate;
    private int staffTypeId;

    public StaffRequest() 
    {

    } 
    public StaffRequest(String citizenId,String name, String phone, String email, Date dob, String gender, String address, Date createdDate, int staffTypeId)
    {
        this.citizenId=citizenId;
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.dob=dob;
        this.gender=gender;
        this.address=address;
        this.createdDate=createdDate;
        this.staffTypeId=staffTypeId; 
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
    public int getStaffTypeId() 
    {
        return this.staffTypeId;
    }
    /*
        his.citizenId=citizenId;
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.dob=dob;
        this.gender=gender;
        this.address=address;
        this.createdDate=createdDate;
        this.staffType=staffType; 
     */

}
