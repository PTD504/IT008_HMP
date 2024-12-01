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

    public StaffType() 
    {

    }
    public StaffType(int id, String staffTypeText)
    {
        this.id=id;
        this.staffTypeText=staffTypeText;
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
