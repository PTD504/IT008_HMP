package com.example.demo.controllers;

import com.example.demo.dtos.StudentDto;
import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping({"", "/"})
    public String showStudentList(Model model) {
        List<Student> students = service.getAllStudents();
        model.addAttribute("student_list", students);
        return "students/index";
    }

    @GetMapping("/create")
    public String createStudent(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentDto", studentDto);
        return "students/create";
    }

    @PostMapping("/create")
    public String createStudent(
        @ModelAttribute StudentDto studentDto,
        BindingResult result
    ) {
        if (result.hasErrors()) {
            return "students/create";
        }

        Student student = new Student();

        student.setName(studentDto.getName());
        student.setDoBirth(studentDto.getDoBirth());
        student.setMajor(studentDto.getMajor());
        student.setGPA(studentDto.getGPA());

        service.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/edit")
    public String editStudent(Model model, @RequestParam int id) {
        try {
            Student student = service.findById(id);
            model.addAttribute("student", student);

            StudentDto studentDto = new StudentDto();

            studentDto.setName(student.getName());
            studentDto.setDoBirth(student.getDoBirth());
            studentDto.setMajor(student.getMajor());
            studentDto.setGPA(student.getGPA());

            model.addAttribute("studentDto", studentDto);

        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            return "redirect:/students";
        }

        return "students/edit";
    }

    @PostMapping("/edit")
    public String editStudent(
            Model model,
            @RequestParam int id,
            @ModelAttribute StudentDto studentDto,
            BindingResult result
    ) {
        try {
            Student student = service.findById(id);
            model.addAttribute("student", student);

            if (result.hasErrors()) {
                return "students/edit";
            }

            student.setName(studentDto.getName());
            student.setDoBirth(studentDto.getDoBirth());
            student.setMajor(studentDto.getMajor());
            student.setGPA(studentDto.getGPA());

            service.saveStudent(student);
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam int id) {
        try {
            Student student = service.findById(id);
            service.deleteStudent(student);
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        return "redirect:/students";
    }
}
