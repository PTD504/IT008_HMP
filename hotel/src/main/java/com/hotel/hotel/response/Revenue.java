package com.hotel.hotel.response;

import java.util.List;

public class Revenue {
    public int month;
    public int year;
    public List<RevenueDetail> listRevenueDetail;

    public Revenue()
    {

    }
    public Revenue(int month, int year, List<RevenueDetail> listRevenueDetail) 
    {
        this.month=month;
        this.year=year;
        this.listRevenueDetail=listRevenueDetail;
    } 

    public int getMonth() {
        return this.month;
    } 
    public int getYear() 
    {
        return this.year;
    } 
    public List<RevenueDetail> getListRevenueDetail() 
    {
        return this.listRevenueDetail;
    }

}
