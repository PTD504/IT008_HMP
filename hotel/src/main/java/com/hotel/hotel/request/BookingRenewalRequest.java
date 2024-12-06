package com.hotel.hotel.request;

import java.sql.Date;

public class BookingRenewalRequest {
    private Date newCheckoutDate;
    public BookingRenewalRequest() 
    {

    } 
    public BookingRenewalRequest(Date newCheckoutDate) 
    {
        this.newCheckoutDate=newCheckoutDate;
    }
    public Date getNewCheckoutDate() 
    {
        return this.newCheckoutDate;
    }

}
