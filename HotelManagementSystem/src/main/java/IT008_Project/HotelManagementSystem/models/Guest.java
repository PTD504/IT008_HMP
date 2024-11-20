package IT008_Project.HotelManagementSystem.models;

import jakarta.persistence.*;

import java.time.LocalDate;

import IT008_Project.HotelManagementSystem.dtos.GuestCreationRequest;

@Entity
@Table(name = "Guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="guest_id", columnDefinition="INT")
    private int id;

    @Column(name = "guest_name")
    private String name;

    @Column(name = "guest_birth")
    private LocalDate birth;

    @Column(name = "guest_phone")
    private String phoneNumber;

    @Column(name = "guest_email")
    private String email;

    @Column(name = "guest_address")
    private String address;

    @Column(name = "guest_identitycard")
    private String identityCard; 


    public Guest() 
    { 

    } 
    public Guest(int id, String name, LocalDate birth, String phoneNumber, String email, String address, String identityCard) 
    {
        this.id=id; 
        this.name=name;
        this.birth=birth;   
        this.phoneNumber=phoneNumber;
        this.email= email;
        this.address=address;
        this.identityCard= identityCard;
    } 

    public Guest(int id, GuestCreationRequest request) 
    { 
        this.id=id; 
        this.name=request.getName();
        this.birth=request.getBirthDate();
        this.phoneNumber=request.getPhoneNumber();
        this.email=request.getEmail();
        this.address= request.getAddress();
        this.identityCard=request.getGuestIdentityCardId();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }
}
