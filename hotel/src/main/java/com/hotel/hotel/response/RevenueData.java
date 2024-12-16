package com.hotel.hotel.response;

import java.util.ArrayList;
import java.util.List;

public class RevenueData {
    private String month;
    private int revenue;
    private List<RevenueDetailData> details;
    private String id;

    public RevenueData()
    {
        this.month="";
        this.revenue=0;
        

    } 
    public RevenueData(String month, int revenue) 
    {
        this.month=month;
        this.revenue=revenue;
        this.details=new ArrayList<>(); 
        this.id=this.month.substring(6);
    } 
    public RevenueData(String month, int revenue, List<RevenueDetailData> details) 
    {
        this.month=month;
        this.revenue=revenue;
        this.details = details; 
        this.id=this.month.substring(6);
    }
    public String getId() 
    {
        return this.id;
    }

    public String getMonth() 
    {
        return this.month;
    } 
    public int getRevenue() 
    {
        return this.revenue;
    } 
    public List<RevenueDetailData> getDetails() 
    {
        return this.details;
    } 
    public void setRevenue(int revenue) 
    {
        this.revenue=revenue;
    } 
    public void addDetail(RevenueDetailData detailData) 
    {
        this.details.add(detailData);
        this.revenue+=detailData.getRevenue();
    }

}
