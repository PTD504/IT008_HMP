package com.hotel.hotel.model;
import java.sql.Date;

import jakarta.persistence.CascadeType;
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
@Table(name="BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="ID", columnDefinition = "INT")
    private int id; 

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ROOMID", columnDefinition = "INT", referencedColumnName = "ID") 
    private Room room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="GUESTID", columnDefinition = "INT", referencedColumnName = "ID") 
    private Guest guest;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="STAFFID", columnDefinition = "INT", referencedColumnName = "ID") 
    private Staff staff;

    @Column(name="CHECKINDATE", columnDefinition = "DATE") 
    private Date checkinDate;
    @Column(name="CHECKOUTDATE", columnDefinition="DATE") 
    private Date checkoutDate;

    @Column(name="ISPAID", columnDefinition = "BOOLEAN")
    private boolean isPaid;

    @Column(name="TOTALPRICE", columnDefinition = "INT") 
    private int totalPrice;

    public Booking() 
    {

    } 
    public Booking(Room room, Guest guest, Staff staff, Date checkinDate, Date checkoutDate, boolean isPaid, int totalPrice) 
    {
        
        this.room=room;
        this.guest=guest;
        this.staff=staff;
        this.checkinDate=checkinDate;
        this.checkoutDate=checkoutDate;
        this.isPaid=isPaid;
        this.totalPrice=totalPrice;
    } 

    public int getId() 
    {
        return this.id;
    } 
    public Room getRoom() 
    {
        return this.room;
    } 
    public Guest getGuest() 
    {
        return this.guest;
    } 
    public Staff getStaff() 
    {
        return this.staff;
    }
    public Date getCheckinDate() 
    {
        return this.checkinDate;
    }
    public Date getCheckoutDate() 
    {
        return this.checkoutDate;
    }
    public boolean getIsPaid() 
    {
        return this.isPaid;
    }
    public int getTotalPrice() 
    {
        return this.totalPrice;
    }
    public void setRoom(Room room) 
    {
        this.room=room;
    } 
    public void setGuest(Guest guest) 
    {
        this.guest=guest;
    }
    public void setStaff(Staff staff) 
    {
        this.staff=staff;
    } 
    public void setCheckinDate(Date checkinDate) 
    {
        this.checkinDate=checkinDate;
    } 
    public void setCheckoutDate(Date checkoutDate) 
    {
        this.checkoutDate=checkoutDate;
    }
    public void setIsPaid(boolean isPaid) 
    {
        this.isPaid=isPaid;
    } 
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice=totalPrice;
    }



}
