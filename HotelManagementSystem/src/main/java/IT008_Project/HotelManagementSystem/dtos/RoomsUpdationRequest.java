package IT008_Project.HotelManagementSystem.dtos;

public class RoomsUpdationRequest {
    private int id; 
    private int room_number; 
    private int floor;
    private int room_type; 
    private boolean room_status;  
    public RoomsUpdationRequest()
    {

    }
    public RoomsUpdationRequest(int id, int room_number, int floor, int room_type, boolean room_status) 
    { 
        this.id=id; 
        this.room_number=room_number; 
        this.floor=floor; 
        this.room_type=room_type; 
        this.room_status=room_status;
    }  

    public int getId()
    {
        return this.id;

    }
    public int getRoom_Number() 
    { 
        
        return this.room_number; 
    } 
    public int getFloor()
    {
        return this.floor;
    } 
    public int getRoom_Type() 
    { 
        return this.room_type;
    } 
    public boolean getRoom_Status() 
    { 
        return this.room_status;
    }



}
