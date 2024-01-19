package com.kart.employeeManagement.service;

import com.kart.employeeManagement.data.Employee;
import com.kart.employeeManagement.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    // Inject the EmployeeDatabase object
    @Autowired
    private EmployeeRepository employeeDatabase;


    private Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    // Create a method to save an employee
    public Employee saveEmployee(Employee employee) {
        // Call the saveEmployee method of
        logger.info("Creating in employeeDatabase", employee);

        return employeeDatabase.saveEmployee(employee);
    }

    public List<Employee> saveEmployees(List<Employee> employee) {
        // Call the saveEmployee method of
        for (Employee e : employee) {
            logger.info("Creating in employeeDatabase for employeeId", e.getId());
            employeeDatabase.saveEmployee(e);
        }
        logger.info("Creating in employeeDatabase", employee);

        return employee;
    }

    // Create a method to find an employee by id
    public Employee findEmployeeById(String id) {
        // Call the findEmployeeById method of EmployeeDatabase
        return employeeDatabase.findEmployeeById(id);
    }

    // Create a method to find all employees
    public List<Employee> findAllEmployees() {
        // Call the findAllEmployees method of EmployeeDatabase
        return employeeDatabase.findAllEmployees();
    }

    // Create a method to update an employee by id
    public Employee updateEmployeeById(String id, Employee employee) {
        // Call the updateEmployeeById method of EmployeeDatabase
        return employeeDatabase.updateEmployeeById(id, employee);
    }

    // Create a method to delete an employee by id
    public void deleteEmployeeById(String id) {
        // Call the deleteEmployeeById method of EmployeeDatabase
        employeeDatabase.deleteEmployeeById(id);
    }

    // Create a method to update an employee's salary by id
    public Employee updateEmployeeSalaryById(String id, double salary) {
        // Create an employee object with the new salary
        Employee employee = new Employee();
        employee.setSalary(salary);
        // Call the updateEmployeeById method of EmployeeDatabase with the employee object
        return employeeDatabase.updateEmployeeById(id, employee);
    }

    // Create a method to update an employee's phone number by id
    public Employee updateEmployeePhoneNumberById(String id, List<String> phoneNumber) {
        // Create an employee object with the new phone number
        Employee employee = new Employee();
        employee.setPhoneNumber(phoneNumber);
        // Call the updateEmployeeById method of EmployeeDatabase with the employee object
        return employeeDatabase.updateEmployeeById(id, employee);
    }
}


