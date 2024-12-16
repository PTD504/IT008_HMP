package com.hotel.hotel.response;

import java.util.ArrayList;
import java.util.List;

public class Revenue {
    private List<RevenueData> revenueData;
    public Revenue() 
    {
        this.revenueData=new ArrayList<>();
    } 
    public Revenue(List<RevenueData> revenueData)
    {
        this.revenueData=revenueData;
    }

    public List<RevenueData> getRevenueData() 
    {
        return this.revenueData;
    } 
    public void addRevenueData(RevenueData revenueData) 
    {
        this.revenueData.add(revenueData);
    }
    


}
