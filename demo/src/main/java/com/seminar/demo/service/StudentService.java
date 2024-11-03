package com.seminar.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seminar.demo.entity.Student;
import com.seminar.demo.repository.StudentRepository;
import com.seminar.demo.request.StudentCreationRequest;

@Service
public class StudentService { 
    @Autowired 
    private StudentRepository studentRepo; 

    public List<Student> getAll()// Fetch tat ca hoc sinh
    { 
        return studentRepo.findAll();
    } 
    public Student getById(int id) //Tim kiem hoc sinh bang id
    {
        return studentRepo.findById(id).orElse(new Student(-1,"",-1.0f,false));
    } 

    public String createStudent(StudentCreationRequest request) 
    {
        List<Student> list=studentRepo.findAll(); 
        int id=list.size();
        studentRepo.save(new Student(id, request.getName(), request.getScore(),true));
        return "Tao sinh vien thanh cong";
    } 

    public String updateStudent(Student student) 
    { 
        Student target= studentRepo.findById(student.getId()).orElse(null);   
        if(target==null) return "Sinh vien khong ton tai"; 
        target.setName(student.getName()); 
        target.setScore(student.getScore()); 
        target.setEnable(student.getEnable()); 
        studentRepo.save(target);
        return "Cap nhat thong tin thanh cong";
    } 

    public String deleteStudent(int id) 
    { 
        Student student=studentRepo.findById(id).orElse(null);
        if(student==null) return "Sinh vien khong ton tai"; 
        studentRepo.delete(student);
        return "Xoa sinh vien thanh cong";
    }

}
