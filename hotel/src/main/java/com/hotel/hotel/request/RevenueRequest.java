package com.hotel.hotel.request;

public class RevenueRequest { 
    private int month;
    private int year;

    public RevenueRequest() 
    {

    } 
    public RevenueRequest(int month, int year) 
    {
        this.month=month;
        this.year=year;
    } 

    public int getMonth() 
    {
        return this.month;
    } 
    public int getYear() 
    {
        return this.year;
    }

}
