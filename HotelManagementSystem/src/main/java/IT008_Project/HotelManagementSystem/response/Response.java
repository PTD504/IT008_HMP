package IT008_Project.HotelManagementSystem.response;

public class Response { 
    private Object data;
    public String message;
    public Response() 
    {

    } 
    public Response(Object data, String message) 
    { 
        this.data= data; 
        this.message= message;
    } 
    public Object getData() 
    { 
        return this.data;
    } 
    public String getMessage() 
    { 
        return this.message;
    }
    
}
