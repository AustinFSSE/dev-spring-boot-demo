package dev.alm.cruddemo.service;
import dev.alm.cruddemo.dao.EmployeeRepository;
import dev.alm.cruddemo.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List <Employee> findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee findById(int id) {

        Optional <Employee> employee = employeeRepository.findById(id);

        Employee emp = null;

        if (employee.isPresent()) {
            emp = employee.get();
        } else {
            throw new RuntimeException("Employee with id " + id + " not found");
        }

        return emp;
    }
    
    @Override
    public Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }
    
    @Override
    public void deleteById(int id) {

        employeeRepository.deleteById(id);
    }
}
