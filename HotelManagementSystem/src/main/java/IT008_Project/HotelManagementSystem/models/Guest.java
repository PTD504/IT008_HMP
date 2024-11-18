package IT008_Project.HotelManagementSystem.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "guest_identityCard")
    private String identityCard;

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
