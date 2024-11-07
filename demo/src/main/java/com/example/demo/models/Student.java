package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String Name;
    private LocalDate DoBirth;
    private String Major;
    private float GPA;

    public int getId() {
        return Id;
    }

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
