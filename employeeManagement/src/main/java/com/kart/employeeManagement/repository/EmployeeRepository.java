package com.kart.employeeManagement.repository;

import com.kart.employeeManagement.data.Employee;
import com.kart.employeeManagement.db.EmployeeDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Create a service class to handle the business logic
@Service
public class EmployeeRepository {

    // Inject the EmployeeDatabase object
    @Autowired
    private EmployeeDatabase employeeDatabase;

    // Create a method to save an employee
    public Employee saveEmployee(Employee employee) {
        // Call the saveEmployee method of EmployeeDatabase
        return employeeDatabase.saveEmployee(employee);
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
}

