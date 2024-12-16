package com.hotel.hotel.request;

public class ChangePasswordRequest { 
    private String oldPassword;
    private String newPassword;
    public ChangePasswordRequest() 
    {

    } 
    public ChangePasswordRequest(String oldPassword, String newPassword) 
    {
        this.oldPassword=oldPassword;
        this.newPassword=newPassword;
    } 

    public String getOldPassword() 
    {
        return this.oldPassword;
    }
    public String getNewPassword() 
    {
        return this.newPassword;
    }

}
