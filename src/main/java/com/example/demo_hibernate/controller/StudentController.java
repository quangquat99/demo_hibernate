package com.example.demo_hibernate.controller;

import com.example.demo_hibernate.entity.Student;
import com.example.demo_hibernate.model.StudentInfo;
import com.example.demo_hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("/getAllstudents")
    public ResponseEntity<List<StudentInfo>> getAllstudents() {
        List<StudentInfo> list = service.getAllstudents();

        return new ResponseEntity<List<StudentInfo>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getStudentByID")
    public ResponseEntity<Student> getStudentByID(@RequestParam(value = "id") Integer id) {
        Student student = service.getStudentById(id);

        return new ResponseEntity<Student>(student, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/addStudentAuto")
    public ResponseEntity<Student> addDataAuto() {
        service.addDataAuto();

        return new ResponseEntity<Student>(new Student(), new HttpHeaders(), HttpStatus.OK);
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<StudentEntity> getstudentById(@PathVariable("id") Long id)
//            throws RecordNotFoundException {
//        StudentEntity entity = service.getstudentById(id);
//
//        return new ResponseEntity<StudentEntity>(entity, new HttpHeaders(), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<StudentEntity> createOrUpdatestudent(StudentEntity student)
//            throws RecordNotFoundException {
//        StudentEntity updated = service.createOrUpdatestudent(student);
//        return new ResponseEntity<StudentEntity>(updated, new HttpHeaders(), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public HttpStatus deletestudentById(@PathVariable("id") Long id)
//            throws RecordNotFoundException {
//        service.deletestudentById(id);
//        return HttpStatus.FORBIDDEN;
//    }

}