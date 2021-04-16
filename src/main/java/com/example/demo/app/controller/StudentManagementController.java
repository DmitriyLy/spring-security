package com.example.demo.app.controller;

import com.example.demo.app.entity.Student;
import com.example.demo.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private final StudentService studentService;

    @Autowired
    public StudentManagementController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        studentService.delete(id);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable("id") Long id, Student student) {
        studentService.update(id, student);
    }
}
