package com.example.demo.app.controller;

import com.example.demo.app.entity.Student;
import com.example.demo.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void delete(@PathVariable("id") Long id) {
        studentService.delete(id);
    }

    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void update(@PathVariable("id") Long id, Student student) {
        studentService.update(id, student);
    }
}
