package IT008_Project.HotelManagementSystem.models;

import java.sql.Date;

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
@Table(name="BOOKINGS")
public class Bookings { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="booking_id", columnDefinition = "INT") 
    private int bookingId; 

    @ManyToOne
    @JoinColumn(name="guest_id", columnDefinition = "INT", referencedColumnName = "guest_id") 
    private Guest guest;
    
    @ManyToOne
    @JoinColumn(name="room_id", columnDefinition = "INT", referencedColumnName = "room_id") 
    private Rooms room;

    @ManyToOne
    @JoinColumn(name="service_id", columnDefinition = "INT", referencedColumnName = "service_id") 
    private Service service;

    @Column(name="checkin_date", columnDefinition = "DATE") 
    private Date checkinDate;

    @Column(name="checkout_date", columnDefinition = "DATE") 
    private Date checkoutDate;

    @Column(name="total_price", columnDefinition = "INT") 
    private int totalPrice;

    public Bookings() 
    {

    } 
    public Bookings(int bookingId, Guest guest, Rooms room, Service service, Date checkinDate, Date checkoutDate, int totalPrice) 
    {
        this.bookingId=bookingId; 
        this.guest=guest;
        this.room=room;
        this.service=service; 
        this.checkinDate=checkinDate;
        this.checkoutDate=checkoutDate;
    } 

    public int getBookingId()
    {
        return this.bookingId;
    } 
    public Guest getGuest()
    {
        return this.guest;
    } 
    public Rooms getRoom() 
    { 
        return this.room;
    } 
    public Service getService() 
    {
        return this.service;
    } 
    public Date getCheckinDate() 
    {
        return this.checkinDate;
    }
    public Date getCheckoutDate() 
    {
        return this.checkoutDate;
    } 
    public int getTotalPrice() 
    { 
        return this.totalPrice;
    }




}
