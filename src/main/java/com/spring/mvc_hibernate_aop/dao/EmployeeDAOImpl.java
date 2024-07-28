package com.spring.mvc_hibernate_aop.dao;

import com.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    //@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Employee> getAllEmployees() {
        try {
            Session session = sessionFactory.getCurrentSession();
            List<Employee> allEmployee = session.createQuery("from Employee", Employee.class).list();
            //Query<Employee> query=session.createQuery("from Employee ",Employee.class);//второй варинат добавления
            //List<Employee> allEmp=query.list();
            return allEmployee;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session=sessionFactory.getCurrentSession();
        session.save(employee);
    }

}
