package com.seminar.demo.request;

public class StudentCreationRequest { 
    private String name; 
    private float score; 

    public StudentCreationRequest() 
    {

    } 
    public StudentCreationRequest(String name, float score) 
    {
        this.name=name; 
        this.score=score; 

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

}
