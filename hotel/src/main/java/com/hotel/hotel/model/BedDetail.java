package com.hotel.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.experimental.FieldNameConstants;

@Entity
@FieldNameConstants
@Table(name="BEDDETAIL")
public class BedDetail { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="ID", columnDefinition = "INT")
    private int id; 

    @Column(name="BEDDETAILTEXT", columnDefinition = "VARCHAR(100)") 
    private String bedDetailText; 
    @Column(name="USABLE", columnDefinition = "BOOLEAN") 
    private boolean usable;

    public BedDetail()
    {

    } 
    public BedDetail(String bedDetailText) 
    {
        
        this.bedDetailText=bedDetailText; 
        this.usable=true;
    }
    public int getId() 
    {
        return this.id;
    } 
    public String getBedDetailText(){
        return this.bedDetailText;
    } 
    public void setBedDetailText(String bedDetailText) 
    { 
        this.bedDetailText=bedDetailText;
    } 
    public boolean getUsable()
    {
        return this.usable;
    } 
    public void setUsable(boolean usable) 
    {
        this.usable=usable;
    }
}
