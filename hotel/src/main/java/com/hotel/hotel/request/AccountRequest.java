package com.hotel.hotel.request;

public class AccountRequest {
    private String email;
    private String password;
    private int staffId;
    public AccountRequest() 
    {

    } 
    public AccountRequest(String email, String password, int staffId) 
    {
        this.email=email;
        this.password=password;
        this.staffId=staffId;
    } 

    public String getEmail() 
    {
        return this.email;
    } 
    public String getPassword()
    {
        return this.password;
    } 
    public int getStaffId() 
    {
        return this.staffId;
    }

}
