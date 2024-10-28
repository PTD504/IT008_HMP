package com.seminar.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="STUDENT")
public class Student {  
    @Id 
    @Column(name="ID", columnDefinition="INT PRIMARY KEY", nullable=false)
    private int id;

    @Column(name="NAME", columnDefinition="VARCHAR(100)") 
    private String name; 

    @Column(name="SCORE", columnDefinition="FLOAT(24)")
    private float score; 

    @Column(name="ENABLE", columnDefinition="BOOLEAN") 
    private boolean enable;
    public Student() 
    {

    } 
    public Student(int id, String name, float score, boolean enable) 
    {
        this.id=id; 
        this.name=name; 
        this.score=score; 
        this.enable=enable;
    } 

    public int getId() 
    {
        return this.id; 
    } 
    public void setId(int id) 
    {
        this.id=id;
    } 
    public String getName() 
    {
        return this.name;
    } 
    public void setName(String name) 
    {
        this.name=name;
    } 
    public float getScore() 
    {
        return this.score;
    } 
    public void setScore(float score) 
    { 
        this.score=score;
    } 
    public boolean getEnable() 
    {
        return this.enable;
    } 
    public void setEnable(boolean enable) 
    { 
        this.enable=enable;
    }

}
