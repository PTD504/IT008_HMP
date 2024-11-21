package IT008_Project.HotelManagementSystem.dtos;

public class AccountCreationRequest { 
    private String userName; 
    private String password;
    private int employeeId;
    public AccountCreationRequest()
    { 

    } 
    public AccountCreationRequest(String userName, String password, int employeeId) 
    {
        this.userName= userName;
        this.password= password; 
        this.employeeId=employeeId;
    } 

    public String getUserName()
    {
        return this.userName;
    } 
    public String getPassword() 
    {
        return this.password;
    } 
    public int getEmployeeId()
    {
        return this.employeeId; 
    }

}
