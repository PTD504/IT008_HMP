package IT008_Project.HotelManagementSystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

@Entity 
@FieldNameConstants
@Table(name="accounts")
public class Accounts { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) 
    @Column(name="account_id", columnDefinition = "INT") 
    private int accountId; 

    @Column(name="username", columnDefinition = "VARCHAR(50)") 
    private String userName;

    @Column(name="password", columnDefinition = "VARCHAR(50)") 
    private String password;

    @ManyToOne 
    @JoinColumn(name="employee_id", columnDefinition="INT", referencedColumnName = "employee_id") 
    private Employee employee;

    public Accounts() 
    {

    } 

    public Accounts(int accountId, String userName, String password, Employee employee) 
    {
        this.accountId=accountId;
        this.userName=userName;
        this.password= password;
        this.employee= employee;
    } 

    public int getAccountId() 
    {
        return this.accountId;
    } 
    public String getUserName() 
    {  
        return this.userName;
    } 
    public String getPassword() 
    { 
        return this.password;
    } 
    public Employee getEmployee() 
    { 
        return this.employee;
    }

    public void setUserName(String userName) 
    { 
        this.userName= userName;
    } 
    public void setPassword(String password) 
    { 
        this.password = password;
    } 
    public void setEmployee(Employee employee) 
    { 
        this.employee= employee;
    }

}
