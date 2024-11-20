package IT008_Project.HotelManagementSystem.dtos;

import java.sql.Date;
import java.time.LocalDate;

public class GuestCreationRequest { 
    private String guestIdentityCardId; 
    private String name; 
    private String phoneNumber; 
    private String email;
    private LocalDate birthDate;
    private String address; 
    public GuestCreationRequest() { 

    } 
    public GuestCreationRequest(String guestIdentityCardId, String name, String phoneNumber, String email, LocalDate birthDate, String address) 
    {
        this.guestIdentityCardId= guestIdentityCardId;
        this.name=name; 
        this.phoneNumber=phoneNumber;
        this.email= email;
        this.birthDate= birthDate;
        this.address=address;
    } 
    public String getGuestIdentityCardId() 
    { 
        return this.guestIdentityCardId;
    } 
    public String getName() 
    {
        return this.name;
    } 
    public String getPhoneNumber() 
    {
        return this.phoneNumber;
    } 
    public String getEmail() 
    {
        return this.email;
    } 
    public LocalDate getBirthDate() 
    { 
        return this.birthDate;
    } 
    public String getAddress() 
    { 
        return this.address;
    }


}
