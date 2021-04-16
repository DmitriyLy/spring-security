package com.example.demo.app.service;


import com.example.demo.app.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    void create(Student student);

    void delete(Long id);

    void update(Long id, Student student);
}
