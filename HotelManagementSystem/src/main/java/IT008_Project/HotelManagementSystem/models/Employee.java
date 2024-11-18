package IT008_Project.HotelManagementSystem.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_birth")
    private LocalDate birth;

    @Column(name = "employee_phone")
    private String phoneNumber;

    @Column(name = "employee_email")
    private String email;

    @Column(name = "employee_position")
    private short position;

    @Column(name = "employee_hire")
    private LocalDate hire;

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

    public short getPosition() {
        return position;
    }

    public void setPosition(short position) {
        this.position = position;
    }

    public LocalDate getHire() {
        return hire;
    }

    public void setHire(LocalDate hire) {
        this.hire = hire;
    }
}
