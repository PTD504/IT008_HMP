package com.example.demo.dtos;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDate;

public class StudentDto {
    private String Name;

    private LocalDate DoBirth;
    private String Major;
    private float GPA;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getDoBirth() {
        return DoBirth;
    }

    public void setDoBirth(LocalDate doBirth) {
        DoBirth = doBirth;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }
}
