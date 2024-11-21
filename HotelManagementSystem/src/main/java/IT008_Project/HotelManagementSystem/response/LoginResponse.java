package IT008_Project.HotelManagementSystem.response;

public class LoginResponse { 
    private int employeeId;
    private int role; 
    private String message;
    public LoginResponse() 
    {

    } 
    public LoginResponse(int employeeId, int role, String message) 
    { 
        this.employeeId= employeeId;
        this.role= role; 
        this.message= message;
    } 

    public int getEmployeeId() 
    { 
        return this.employeeId;
    } 
    public int getRole() 
    { 
        return this.role;
    } 
    public String getMessage()
    {
        return this.message;
    }
}
