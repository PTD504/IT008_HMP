package IT008_Project.HotelManagementSystem.dtos;

public class LoginRequest { 
    private String userName;
    private String password; 

    public LoginRequest() 
    { 

    } 
    public LoginRequest(String userName, String password)
    { 
        this.userName= userName; 
        this.password= password;
    } 
    public String getUserName() 
    { 
        return this.userName;
    } 
    public String getPassword() 
    { 
        return this.password;
    }
}
