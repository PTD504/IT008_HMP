package com.hotel.hotel.request;

public class BedDetailCreationRequest { 
    private String bedDetailText;
     public BedDetailCreationRequest() 
     {

     }
     public BedDetailCreationRequest(String bedDetailText) 
     {
        this.bedDetailText=bedDetailText;
     } 
     public String getBedDetailText() 
     {
        return this.bedDetailText;
     }

}
