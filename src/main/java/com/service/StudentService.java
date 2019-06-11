package com.service;

import com.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    Student findByName(String name);
    Student findById(int student_id);
    void SaveStudent(Student student);
    void UpdateStudent(Student student);
    void DeleteStudent(int student_id);

}
