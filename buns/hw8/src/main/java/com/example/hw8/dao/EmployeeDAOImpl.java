package com.example.hw8.dao;

import com.example.hw8.entity.Employee;
//import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private EntityManager manager;

    @Override
    public List<Employee> getAll() {
        //Session session = manager.unwrap(Session.class);
        //return session.createQuery("from Employee", Employee.class).getResultList();
        Query query = manager.createQuery("from Employee");
        return query.getResultList();
    }

    @Override
    public void save(Employee employee) {
        //Session session = manager.unwrap(Session.class);
        //session.saveOrUpdate(employee);
        Employee newEmp = manager.merge(employee);
        employee.setId(newEmp.getId());
    }

    @Override
    public Employee getEmployee(int id) {
        //Session session = manager.unwrap(Session.class);
        //Employee employee = session.get(Employee.class, id);
        return manager.find(Employee.class, id);
    }

    @Override
    public void delete(int id) {
        //Session session = manager.unwrap(Session.class);
        //Employee employee = session.get(Employee.class, id);
        //session.delete(employee);
        //Query<Employee> query = session.createQuery("delete from Employee where id =:empId");
        //query.setParameter("empId", id);
        //query.executeUpdate();

        Query query = manager.createQuery("delete from Employee where id =:empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
