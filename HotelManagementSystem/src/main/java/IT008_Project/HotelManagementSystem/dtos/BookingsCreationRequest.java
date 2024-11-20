package IT008_Project.HotelManagementSystem.dtos;

import java.sql.Date;



public class BookingsCreationRequest { 
    private int roomId; 
    private Date checkinDate;
    private Date checkoutDate;
    private GuestCreationRequest guestRequest;  
    private int serviceId; 
    private int totalPrice;
    public BookingsCreationRequest() 
    { 

    } 
    public BookingsCreationRequest(int roomId, Date checkinDate, Date checkoutDate, GuestCreationRequest guestRequest, int serviceId, int totalPrice)
    {
        this.roomId= roomId; 
        this.checkinDate= checkinDate; 
        this.checkoutDate= checkoutDate; 
        this.guestRequest= guestRequest; 
        this.serviceId= serviceId; 
        this.totalPrice= totalPrice;
    }

    public int getRoomId() 
    { 
        return this.roomId;
    } 
    public Date getCheckinDate() 
    { 
        return this.checkinDate;
    } 
    public Date getCheckoutDate() 
    { 
        return this.checkoutDate;
    } 
    public GuestCreationRequest getGuestRequest() 
    { 
        return this.guestRequest;
    } 
    public int getServiceId() 
    {
        return this.serviceId;
    } 
    public int getTotalPrice() 
    {
        return this.totalPrice;
    }


}
