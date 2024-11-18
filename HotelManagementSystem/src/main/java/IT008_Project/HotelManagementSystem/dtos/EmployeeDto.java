package IT008_Project.HotelManagementSystem.dtos;

import java.time.LocalDate;

public class EmployeeDto {
    private String name;
    private LocalDate birth;
    private String phoneNumber;
    private String email;
    private short position;
    private LocalDate hire;

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
