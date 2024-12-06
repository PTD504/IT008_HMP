package com.hotel.hotel.response;

public class RevenueDetail { 
    private String roomTypeText;
    private int totalPrice;
    public RevenueDetail() 
    {

    } 
    public RevenueDetail(String roomTypeText, int totalPrice) 
    {
        this.roomTypeText=roomTypeText;
        this.totalPrice=totalPrice;
    }
    public String getRoomTypeText() 
    {
        return this.roomTypeText;
    } 
    public int getTotalPrice() 
    {
        return this.totalPrice;
    } 
    public void addTotalPrice(int amount) 
    {
        this.totalPrice=this.totalPrice+amount;
    }
}
