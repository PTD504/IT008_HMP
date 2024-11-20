package IT008_Project.HotelManagementSystem.models;

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
@Table(name="Rooms")
public class Rooms { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="room_id", columnDefinition="INT") 
    private int room_id; 

    @Column(name="room_number", columnDefinition = "INT") 
    private int room_number;

    @Column(name="floor", columnDefinition = "INT") 
    private int floor;

    @ManyToOne
    @JoinColumn(name="room_type_id", columnDefinition = "INT", referencedColumnName = "type_id") 
    private RoomTypes room_type;

    @Column(name="room_status", columnDefinition = "BOOLEAN") 
    private boolean room_status;

    public Rooms() 
    { 

    } 
    public Rooms(int room_id, int room_number, int floor, RoomTypes room_type, boolean room_status) 
    { 
        this.room_id=room_id; 
        this.room_number=room_number;
        this.floor=floor;
        this.room_type=room_type;
        this.room_status=room_status;
    } 

    public int getRoom_Id() 
    {
        return this.room_id;
    } 
    public int getRoom_Number() 
    {
        return this.room_number;
    } 
    public RoomTypes getRoom_Types() 
    {
        return this.room_type;
    } 
    public boolean getRoom_Status() 
    {
        return this.room_status;
    }

    public void setRoom_Number(int room_number) 
    { 
        this.room_number=room_number;
    } 
    public void setFloor(int floor) 
    { 
        this.floor=floor;
    } 
    public void setRoom_Type(RoomTypes room_type) 
    { 
        this.room_type=room_type;
    } 
    public void setRoom_Status(boolean room_status) 
    {
        this.room_status= room_status;
    }

}
