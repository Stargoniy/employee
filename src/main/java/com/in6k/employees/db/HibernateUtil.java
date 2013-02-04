package com.in6k.employees.db;

import com.in6k.employees.domain.EmployeeModel;

import org.hibernate.*;
import org.hibernate.cfg.*;

import java.io.File;

public class HibernateUtil {
    public static void main(String[] args) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setName("petya");
        employeeModel.setSurname("ivanov");
        employeeModel.setEmail("ivanov@gmail.com");
        employeeModel.setPassword("123");
        employeeModel.setBirhdate("12-11-1991");

//        Configuration configuration = new Configuration();
//        File f =new File(".");

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(employeeModel);
        session.close();
    }
}
