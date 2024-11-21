package IT008_Project.HotelManagementSystem.response;

import IT008_Project.HotelManagementSystem.models.Bookings;

public class BookingResponse { 
    
    private Bookings data; 
    public BookingResponse() 
    {

    } 
    public BookingResponse(Bookings data) 
    {
         
        this.data= data;
    } 

    
     public Bookings getData() 
     { 
        return this.data;
     }

}
