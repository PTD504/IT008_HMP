package com.seminar.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seminar.demo.entity.Student;
import com.seminar.demo.request.StudentCreationRequest;
import com.seminar.demo.service.StudentService;

@RestController
public class StudentController { 
    @Autowired 
    private StudentService studentService; 

    @GetMapping("/students") 
    public List<Student> getAll() 
    {
        return studentService.getAll();
    } 

    @GetMapping("/student/{id}") 
    public Student getById(@PathVariable int id) 
    { 
        return studentService.getById(id);
    }

    @PostMapping("/create") 
    public  String createStudent(@RequestBody StudentCreationRequest request) 
    { 
        return studentService.createStudent(request);
    } 

    @PutMapping("/update") 
    public String updateStudent(@RequestBody Student student) 
    {
        return studentService.updateStudent(student);
    } 

    @DeleteMapping("/delete/{id}") 
    public String deleteStudent(@PathVariable int id) 
    { 
        return studentService.deleteStudent(id);
    }

}
