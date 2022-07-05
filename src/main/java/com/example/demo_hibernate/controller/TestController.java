package com.example.demo_hibernate.controller;

import com.example.demo_hibernate.entity.Student;
import com.example.demo_hibernate.entity.Subject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/addData")
    public ResponseEntity<String> addData() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student stu = new Student();
        stu.setName("test001");
        stu.setEmail("test001@gmail.com");
        stu.setAge(100);
        entityManager.persist(stu);

        Subject sub1 = new Subject();
        sub1.setName("sub1");
        sub1.setStudent(stu);

        Subject sub2 = new Subject();
        sub2.setName("sub2");
        sub2.setStudent(stu);

        entityManager.persist(sub1);
        entityManager.persist(sub2);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.OK);
    }
}
