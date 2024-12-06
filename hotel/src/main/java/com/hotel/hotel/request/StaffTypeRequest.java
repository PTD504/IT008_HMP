package com.hotel.hotel.request;

public class StaffTypeRequest { 
    private String staffTypeText;
    public StaffTypeRequest() 
    {

    } 
    public StaffTypeRequest(String staffTypeText) 
    {
        this.staffTypeText=staffTypeText;
    } 
    public String getStaffTypeText() 
    {
        return this.staffTypeText;
    }

}
