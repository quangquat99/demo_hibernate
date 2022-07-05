package com.example.demo_hibernate.dao;

import com.example.demo_hibernate.config.MysqlHibernateUtil;
import com.example.demo_hibernate.entity.Employee;
import com.example.demo_hibernate.entity.Student;
import com.example.demo_hibernate.model.StudentInfo;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class EmployeeDao {


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }
    public List<Employee> findAll() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }
    public void delete(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
    }
    public void close() {
        entityManager.close();
    }

    public void addDataAuto() {
        entityManager.getTransaction().begin();
        Employee employee = new Employee();
        employee.setFirstName("first1");
        employee.setLastName("last1");
        employee.setSalary(150);
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }
}
