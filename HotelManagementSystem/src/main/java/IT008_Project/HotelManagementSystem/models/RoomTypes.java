package IT008_Project.HotelManagementSystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.experimental.FieldNameConstants;

@Entity 
@FieldNameConstants
@Table(name="room_types")
public class RoomTypes { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="type_id", columnDefinition ="INT") 
    private int id; 

    @Column(name="type_name", columnDefinition = "NVARCHAR(100)") 
    private String type_name;

    @Column(name="type_room_price", columnDefinition = "INT") 
    private int type_room_price;

    @Column(name="capacity", columnDefinition = "SMALLINT") 
    private int capacity;

    public RoomTypes() 
    {

    } 
    public RoomTypes(int id, String type_name, int type_room_price, int capacity)
    {
        this.id=id; 
        this.type_name=type_name;
        this.type_room_price=type_room_price;
        this.capacity=capacity;
    }  

    public int getId() 
    { 
        return this.id;
    } 
    public String getType_Name() { 
        return this.type_name;
    } 
    public int getType_Room_Price() 
    {
        return this.type_room_price;
    } 
    public int getCapacity() 
    { 
        return this.capacity; 
    } 
    public void setType_Name(String type_name) 
    { 
        this.type_name=type_name;
    }  
    public void setType_Room_Price(int type_room_price) 
    { 
        this.type_room_price=type_room_price;
    } 
    public void setCapacity(int capacity) 
    {
        this.capacity=capacity;
    }

    


}
