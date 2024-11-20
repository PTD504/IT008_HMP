package IT008_Project.HotelManagementSystem.dtos;

public class RoomTypeCreationRequest { 
    private String type_name;
    private int type_room_price;
    private int capacity; 
    public RoomTypeCreationRequest() 
    { 

    } 
    public RoomTypeCreationRequest(String type_name, int type_room_price, int capacity) 
    { 
        this.type_name=type_name;
        this.type_room_price=type_room_price;
        this.capacity=capacity;
    } 
    public String getType_Name() 
    { 
        return this.type_name;
    } 
    public  int getType_Room_Price() 
    { 
        return this.type_room_price;
    } 
    public int getCapacity() 
    { 
        return this.capacity;
    }
}
