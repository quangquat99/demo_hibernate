package com.example.demo_hibernate.service;

import com.example.demo_hibernate.dao.EmployeeDao;
import com.example.demo_hibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeDao.findAll();

        if (employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Employee>();
        }
    }

    public Employee getEmployeeById(Integer id) {
        Employee employee = employeeDao.findById(id);

        return employee;
    }

    public void addDataAuto() {
        employeeDao.addDataAuto();
    }
}
