package com.hotel.hotel.model;
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
@Table(name="ROOMTYPE")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="ID", columnDefinition = "INT")
    private int id; 

    @Column(name="ROOMTYPETEXT", columnDefinition = "VARCHAR(100)") 
    private String roomTypeText;

    @Column(name="SIZE", columnDefinition = "INT") 
    private int size;

    @Column(name="PRICE", columnDefinition="INT") 
    private int price;

    @ManyToOne
    @JoinColumn(name="BEDDETAILID", columnDefinition = "INT", referencedColumnName = "ID") 
    private BedDetail bedDetail;

    @Column(name="USABLE", columnDefinition = "BOOLEAN") 
    private Boolean usable;

    public RoomType() 
    {

    } 
    public RoomType(String roomTypeText, int size, int price, BedDetail bedDetail) 
    {
        
        this.roomTypeText=roomTypeText;
        this.size=size; 
        this.price=price;
        this.bedDetail=bedDetail;
        this.usable=true;
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
    public String getRoomTypeText() 
    {
        return this.roomTypeText; 
    } 
    public int getSize() 
    {
        return this.size;
    } 
    public int getPrice() 
    {
        return this.price;
    } 
    public BedDetail getBedDetail() 
    {
        return this.bedDetail;
    }

    public void setBedDetail(BedDetail bedDetail) 
    {
        this.bedDetail=bedDetail;
    } 
    public void setRoomTypeText(String roomTypeText) 
    {
        this.roomTypeText=roomTypeText;
    }
    public void setSize(int size) 
    {
        this.size=size;
    }
    public void setPrice(int price) 
    {
        this.price=price;
    }
    
}
