package dev.alm.cruddemo.entity;

import dev.alm.cruddemo.dao.EmployeeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List <Employee> findAll() {

        // create a query
        TypedQuery <Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = query.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public Employee save(Employee employee) {

        Employee dbEmployee = entityManager.merge(employee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {

        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
