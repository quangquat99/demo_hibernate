package com.example.demo_hibernate.dao;

import com.example.demo_hibernate.config.MysqlHibernateUtil;
import com.example.demo_hibernate.entity.Student;
import com.example.demo_hibernate.model.StudentInfo;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class StudentDAO {

    public Student findById(Integer id) {
        Session session = null;
        Transaction tx = null;
        Student o = null;

        try {

            session = MysqlHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("id", id));
            o = (Student) criteria.uniqueResult();

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return o;
    }

    public List<StudentInfo> listStudentInfo() {
        Session session = null;
        Transaction tx = null;
        try {
            session = MysqlHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            String hql = "select s from Student s";
            Query<Student> query = session.createQuery(hql);
            List<Student> results = query.getResultList();

            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

            List<Student> studentList = results;
            for (Iterator iterator = studentList.iterator(); iterator.hasNext(); ) {
                Student employee = (Student) iterator.next();
            }

            List<StudentInfo> studentInfoList = new ArrayList<>();
            for (Student entity : studentList) {
                StudentInfo studentInfo = new StudentInfo(entity);
                studentInfoList.add(studentInfo);
            }

            tx.commit();
            return studentInfoList;
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public void addDataAuto() {
        Session session = null;
        Transaction tx = null;
        try {
            session = MysqlHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Student s = new Student();
            s.setName("a");
            s.setAge(2);
            s.setEmail("ga@gmal");
            session.save(s);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
