package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student findById(int id) {
        return repo.findById(id).get();
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public void deleteStudent(Student student) {
        repo.delete(student);
    }
}
