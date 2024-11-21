package IT008_Project.HotelManagementSystem.dtos;

public class Request { 
    private int role; 
    private Object requestData; 
    public Request() 
    { 

    } 
    public Request(int role, Object requestData) 
    { 
        this.role= role;
        this.requestData= requestData;
    } 

    public int getRole() 
    {
        return this.role;
    } 
    public Object getRequestData() 
    {
        return this.requestData;
    }


}
