package com.kart.employeeManagement.controller;

import com.kart.employeeManagement.data.Employee;
import com.kart.employeeManagement.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // Inject the EmployeeService object
    @Autowired
    private EmployeeService employeeService;

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    // Create a method to handle the POST request to save an employee
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        // Call the saveEmployee method of EmployeeService and return the response
        logger.info("Creating employee: {}", employee);
        Employee savedEmployee = employeeService.saveEmployee(employee);
        logger.info("Created: {}", employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Create a method to handle the GET request to find an employee by id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable String id) {
        // Call the findEmployeeById method of EmployeeService and return the response
        logger.info("Getting employee by id: {}", id);
        Employee foundEmployee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(foundEmployee, HttpStatus.OK);
    }

    // Create a method to handle the GET request to find all employees
    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployees() {
        // Call the findAllEmployees method of EmployeeService and return the response
        List<Employee> allEmployees = employeeService.findAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    // Create a method to handle the PUT request to update an employee by id
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable String id, @RequestBody Employee employee) {
        // Call the updateEmployeeById method of EmployeeService and return the response
        logger.info("Updating employee by id: {}", id);
        Employee updatedEmployee = employeeService.updateEmployeeById(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Create a method to handle the DELETE request to delete an employee by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable String id) {
        // Call the deleteEmployeeById method of EmployeeService and return the response
        logger.info("Deleting employee by id: {}", id);
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Create a method to handle the PATCH request to update an employee's salary by id
    @PatchMapping("/{id}/salary")
    public ResponseEntity<Employee> updateEmployeeSalaryById(@PathVariable String id, @RequestParam double salary) {
        // Call the updateEmployeeSalaryById method of EmployeeService and return the response
        Employee updatedEmployee = employeeService.updateEmployeeSalaryById(id, salary);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Create a method to handle the PATCH request to update an employee's phone number by id
    @PatchMapping("/{id}/phoneNumber")
    public ResponseEntity<Employee> updateEmployeePhoneNumberById(@PathVariable String id, @RequestParam List<String> phoneNumber) {
        // Call the updateEmployeePhoneNumberById method of EmployeeService and return the response
        Employee updatedEmployee = employeeService.updateEmployeePhoneNumberById(id, phoneNumber);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}

