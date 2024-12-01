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

    public BedDetail()
    {

    } 
    public BedDetail(int id, String bedDetailText) 
    {
        this.id=id;
        this.bedDetailText=bedDetailText;
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
}
