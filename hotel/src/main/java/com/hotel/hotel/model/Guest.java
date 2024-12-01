package com.hotel.hotel.model;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.experimental.FieldNameConstants; 
@Entity
@FieldNameConstants
@Table(name="GUEST")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="ID", columnDefinition = "INT")
    private int id; 
    @Column(name="CITIZENID", columnDefinition = "VARCHAR(100)")
    private String citizenId;

    @Column(name="NAME", columnDefinition ="VARCHAR(100)") 
    private String name;

    @Column(name="PHONE", columnDefinition = "VARCHAR(100)") 
    private String phone;
    
    @Column(name="EMAIL", columnDefinition = "VARCHAR(100)") 
    private String email;

    @Column(name="DOB", columnDefinition = "DATE") 
    private Date dob;

    @Column(name="GENDER", columnDefinition = "VARCHAR(100)") 
    private String gender;

    @Column(name="ADDRESS", columnDefinition = "VARCHAR(100)")
    private String address; 
    public Guest()
    {

    } 
    public Guest(int id, String citizenId, String name, String phone, String email, Date dob, String gender, String address) 
    {
        this.id=id;
        this.citizenId=citizenId;
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.dob=dob;
        this.gender=gender;
        this.address=address;
    }

    public int getId() 
    {
        return this.id;
    } 
    public String getCitizenId() 
    {
        return this.citizenId;
    }
    public String getName() 
    {
        return this.name;
    } 
    public String getPhone() 
    {
        return this.phone;
    }
    public String getEmail() 
    {
        return this.email;
    }
    public Date getDob() 
    {
        return this.dob;
    }
    public String getGender() 
    {
        return this.gender;
    }
    public String getAddress() 
    {
        return this.address;
    }
    public void setCitizenId(String citizenId) 
    {
        this.citizenId= citizenId;
    } 
    public void setName(String name) 
    {
        this.name=name;
    }  
    public void setPhone(String phone) 
    {
        this.phone=phone;
    } 
    public void setEmail(String email) 
    {
        this.email=email;
    } 
    public void setDob(Date dob) 
    {
        this.dob=dob;
    }
    public void setGender(String gender) 
    {
        this.gender=gender;
    }
    public void setAddress(String address) 
    {
        this.address=address;
    }

}
