package com.example.demo_hibernate.service;

import com.example.demo_hibernate.dao.StudentDAO;
import com.example.demo_hibernate.entity.Student;
import com.example.demo_hibernate.model.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    public List<StudentInfo> getAllstudents() {
        List<StudentInfo> studentList = studentDAO.listStudentInfo();

        if (studentList.size() > 0) {
            return studentList;
        } else {
            return new ArrayList<StudentInfo>();
        }
    }

    public Student getStudentById(Integer id) {
        Student student = studentDAO.findById(id);

        return student;
    }

    public void addDataAuto() {

        studentDAO.addDataAuto();
    }
//
//    public StudentEntity createOrUpdatestudent(StudentEntity entity) throws RecordNotFoundException {
//        Optional<StudentEntity> student = repository.findById(entity.getId());
//
//        if (student.isPresent()) {
//            StudentEntity newEntity = student.get();
//            newEntity.setName(entity.getName());
//            newEntity.setAge(entity.getAge());
//            newEntity.setEmail(entity.getEmail());
//
//            newEntity = repository.save(newEntity);
//
//            return newEntity;
//        } else {
//            entity = repository.save(entity);
//
//            return entity;
//        }
//    }
//
//    public void deletestudentById(Long id) throws RecordNotFoundException {
//        Optional<StudentEntity> student = repository.findById(id);
//
//        if (student.isPresent()) {
//            repository.deleteById(id);
//        } else {
//            throw new RecordNotFoundException("No student record exist for given id");
//        }
//    }
}