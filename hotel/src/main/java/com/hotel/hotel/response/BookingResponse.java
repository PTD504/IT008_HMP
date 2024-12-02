package com.hotel.hotel.response;

import java.sql.Date;

import com.hotel.hotel.model.Booking;

public class BookingResponse {
    private int id; 
    private int roomId;
    private String roomNumber;
    private int state;
    private int floor;
    private int roomTypeId;
    private String roomTypeText;
    private int price;
    private int size;
    private int bedDetailId;
    private String bedDetailText;

    private int guestId;
    private String guestName;
    private String citizenId;
    private String phone;
    private String email;
    private Date dob;
    private String gender;
    private String address;

    private int staffId;
    private String staffName;

    private Date checkinDate;
    private Date checkoutDate;
    private boolean isPaid;
    private int totalPrice;

    public BookingResponse() {
    }
    public BookingResponse(Booking booking)
    {
        this.id= booking.getId();
        this.roomId= booking.getRoom().getId();
        this.roomNumber= booking.getRoom().getRoomNumber();
        this.state= booking.getRoom().getState();
        this.floor= booking.getRoom().getFloor();
        this.roomTypeId=booking.getRoom().getRoomType().getId();
        this.roomTypeText= booking.getRoom().getRoomType().getRoomTypeText();
        this.price= booking.getRoom().getRoomType().getPrice();
        this.size= booking.getRoom().getRoomType().getSize();
        this.bedDetailId= booking.getRoom().getRoomType().getBedDetail().getId();
        this.bedDetailText=booking.getRoom().getRoomType().getBedDetail().getBedDetailText();
        
        this.guestId= booking.getGuest().getId();
        this.guestName= booking.getGuest().getName();
        this.citizenId = booking.getGuest().getCitizenId();
        this.phone=booking.getGuest().getPhone();
        this.email=booking.getGuest().getEmail();
        this.dob= booking.getGuest().getDob();
        this.gender= booking.getGuest().getGender();
        this.address= booking.getGuest().getAddress();

        this.staffId= booking.getStaff().getId();
        this.staffName= booking.getStaff().getName();

        this.checkinDate= booking.getCheckinDate();
        this.checkoutDate=booking.getCheckoutDate();
        this.isPaid= booking.getIsPaid();
        this.totalPrice=booking.getTotalPrice();
    }

    public int getId() 
    {
        return this.id;
    } 
    public int getRoomId() 
    {
        return this.roomId;
    } 
    public String getRoomNumber() 
    {
        return this.roomNumber;
    } 
    public int getState() 
    {
        return this.state;
    } 
    public int getFloor() 
    {
        return this.floor;
    } 
    public int getRoomTypeId() 
    {
        return this.roomTypeId;
    }
    public String getRoomTypeText() 
    {
        return this.roomTypeText;
    } 
    public int getPrice() 
    {
        return this.price;
    } 
    public int getSize() 
    {
        return this.size;
    } 
    public int getBedDetailId() 
    {
        return this.bedDetailId;
    }
    public String getBedDetailText() 
    {
        return this.bedDetailText;
    }
    public int getGuestId() 
    {
        return this.guestId;
    }
    public String getGuestName() 
    {
        return this.guestName;
    }
    public String getCitizenId() 
    {
        return this.citizenId;
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
    public int getStaffId() 
    {
        return this.staffId;
    }
    public String getStaffName() 
    {
        return this.staffName;
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
}