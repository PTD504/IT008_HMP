package com.hotel.hotel.request;

public class RevenueRequest { 
    private int revenueYear;
    public RevenueRequest()
    {

    } 
    public RevenueRequest(int revenueYear) 
    {
        this.revenueYear=revenueYear;
    } 
    public int getRevenueYear() 
    {
        return this.revenueYear;
    }
}
