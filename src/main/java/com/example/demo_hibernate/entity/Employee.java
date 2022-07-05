package com.example.demo_hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 45)
    private String firstName;


    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "salary")
    private Integer salary;
}
