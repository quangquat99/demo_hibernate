package com.example.demo_hibernate.controller;

import com.example.demo_hibernate.entity.Employee;
import com.example.demo_hibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = service.getAllEmployees();

        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getEmployeeByID")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam(value = "id") Integer id) {
        Employee employee = service.getEmployeeById(id);

        return new ResponseEntity<Employee>(employee, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/addEmployeeAuto")
    public ResponseEntity<Employee> addDataAuto() {
        service.addDataAuto();

        return new ResponseEntity<Employee>(null, new HttpHeaders(), HttpStatus.OK);
    }
}
