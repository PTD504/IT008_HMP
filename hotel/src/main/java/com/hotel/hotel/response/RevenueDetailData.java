package com.hotel.hotel.response;

public class RevenueDetailData {
    private String roomType;
    private int revenue;
    public RevenueDetailData() 
    {

    } 
    public RevenueDetailData(String roomType, int revenue) 
    {
        this.roomType=roomType;
        this.revenue=revenue;
    }  
    public String getRoomType() 
    {
        return this.roomType;
    } 
    public int getRevenue()
    {
        return this.revenue;
    } 
    public void setRevenue(int revenue)
    {
        this.revenue=revenue;
    }


}
