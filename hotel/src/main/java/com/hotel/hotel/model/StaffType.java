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
@Table(name="STAFFTYPE")
public class StaffType { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="ID", columnDefinition = "INT")
    private int id;  

    @Column(name="STAFFTYPETEXT", columnDefinition = "VARCHAR(100)") 
    private String staffTypeText; 
    @Column(name="USABLE", columnDefinition = "BOOLEAN") 
    private Boolean usable;

    public StaffType() 
    {

    }
    public StaffType(String staffTypeText)
    {
        this.usable=true;
        this.staffTypeText=staffTypeText;
    }  
    public boolean getUsable()
    {
        return this.usable;
    } 
    public void setUsable(boolean usable) 
    {
        this.usable=usable;
    }
    public int getId() 
    {
        return this.id;
    } 
    public String getStaffTypeText()
    {
        return this.staffTypeText;
    }
    public void setStaffTypeText(String staffTypeText) 
    {
        this.staffTypeText=staffTypeText;
    }

}
