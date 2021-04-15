package com.example.demo.app.controller;

import com.example.demo.app.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "John Dow"),
            new Student(2, "Jane Dow"),
            new Student(3, "James Smith")
    );

    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return STUDENTS.stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

}
