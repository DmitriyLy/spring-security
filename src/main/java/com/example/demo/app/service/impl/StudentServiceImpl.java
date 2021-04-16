package com.example.demo.app.service.impl;

import com.example.demo.app.entity.Student;
import com.example.demo.app.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "John Dow"),
            new Student(2, "Jane Dow"),
            new Student(3, "James Smith")
    );

    @Override
    public List<Student> getAll() {
        System.out.println("StudentServiceImpl#getAll");
        return STUDENTS;
    }

    @Override
    public void create(Student student) {
        System.out.println("StudentServiceImpl#create, payload: " + student);
    }

    @Override
    public void delete(Long id) {
        System.out.println("StudentServiceImpl#delete, payload: " + id);
    }

    @Override
    public void update(Long id, Student student) {
        System.out.println("StudentServiceImpl#update, payload: " + id + ", " + student);
    }
}
