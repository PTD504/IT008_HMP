package com.hotel.hotel.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.experimental.FieldNameConstants;

@Entity
@FieldNameConstants
@Table(name="ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", columnDefinition = "INT") 
    private int id;

    @Column(name="EMAIL", columnDefinition = "VARCHAR(45)") 
    private String email;

    @Column(name="PASSWORD", columnDefinition = "Varchar(45)") 
    private String password;
    @ManyToOne
    @JoinColumn(name="STAFFID", columnDefinition = "INT", referencedColumnName = "ID")
    private Staff staff;

    @Column(name="TYPE", columnDefinition = "INT")
    private int type;

    public Account() 
    {

    } 
    public Account( String email, String password, Staff staff, int type) 
    {
        
        this.email=email;
        this.password=password;
        this.staff=staff;
        this.type=type;
    }
    public int getId() 
    {
        return this.id;
    } 
    public String getEmail() 
    {
        return this.email;
    }
    public String getPassword() 
    {
        return this.password;
    } 
    public Staff getStaff() 
    {
        return this.staff;
    } 
    public int getType() 
    {
        return this.type;
    }
    public void setPassword(String password) 
    {
        this.password=password;
    }


}
