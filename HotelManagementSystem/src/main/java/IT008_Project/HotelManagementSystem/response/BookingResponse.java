package IT008_Project.HotelManagementSystem.response;

import IT008_Project.HotelManagementSystem.models.Bookings;

public class BookingResponse { 
    private String message; 
    private Bookings data; 
    public BookingResponse() 
    {

    } 
    public BookingResponse(String message, Bookings data) 
    {
        this.message=message; 
        this.data= data;
    } 

    public String getMessage() 
    { 
        return this.message;
    }
     public Bookings getData() 
     { 
        return this.data;
     }

}
