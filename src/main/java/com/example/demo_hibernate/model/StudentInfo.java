package com.example.demo_hibernate.model;

import com.example.demo_hibernate.entity.Student;
import com.example.demo_hibernate.entity.Subject;
import lombok.Data;

import java.util.List;

@Data
public class StudentInfo {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private List<Subject> subjectList;

    public StudentInfo (Student entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.age = entity.getAge();
        this.subjectList = entity.getListSubject();
    }
}
