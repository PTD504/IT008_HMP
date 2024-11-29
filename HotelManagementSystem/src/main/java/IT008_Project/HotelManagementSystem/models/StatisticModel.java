package IT008_Project.HotelManagementSystem.models;

public class StatisticModel { 
    private RoomTypes roomType;
    private int amount; 
    public StatisticModel()
    {

    } 
    public StatisticModel(RoomTypes roomType, int amount) 
    {
        this.roomType= roomType;
        this.amount=amount;
    } 

    public RoomTypes getRoomType() 
    {
        return this.roomType;
    }
    public int getAmount() 
    {
        return this.amount;
    }

}
