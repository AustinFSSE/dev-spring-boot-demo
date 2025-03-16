package dev.alm.cruddemo.rest;

import dev.alm.cruddemo.entity.Employee;
import dev.alm.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

//    // quick and dirty: inject employee dao directly using our constructor
//    private EmployeeDAO employeeDAO;
//
//    public EmployeeRestController(EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }

    // this way is much cleaner and the preferred way to pass info between DAO and RestController
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    // expose "/employees" and return a list of employees

    @GetMapping("/employees")
    public List <Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employee_id}")
    public Employee findById(@PathVariable int employee_id) {

        Employee employee = employeeService.findById(employee_id);
        if (employee == null)
        {
            throw new RuntimeException("Employee with id " + employee_id + " not found");
        }
        return employee;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setId(0);

        return employeeService.save(employee);
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.save(employee);
    }

    // add mapping for DELETE /employees - delete existing employee
    @DeleteMapping("/employees/{employee_id}")
    public String deleteEmployee(@PathVariable int employee_id) {

        Employee employee = employeeService.findById(employee_id);

        if (employee == null) {
            throw new RuntimeException("Employee with id " + employee_id + " not found");
        }

        employeeService.deleteById(employee_id);

        return "Deleted employee with id " + employee_id;
    }
}
