package com.kart.employeeManagement.db;

// Import the necessary packages
import com.kart.employeeManagement.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class EmployeeDatabase {

    // Inject the MongoTemplate object
    @Autowired
    private MongoTemplate mongoTemplate;

    // Create a method to save an employee
    public Employee saveEmployee(Employee employee) {
        // Use the save method of MongoTemplate to insert or update the employee
        return mongoTemplate.save(employee);
    }

    // Create a method to find an employee by id
    public Employee findEmployeeById(String id) {
        // Use the findById method of MongoTemplate to query the employee by id
        return mongoTemplate.findById(id, Employee.class);
    }

    // Create a method to find all employees
    public List<Employee> findAllEmployees() {
        // Use the findAll method of MongoTemplate to query all employees
        return mongoTemplate.findAll(Employee.class);
    }

    // Create a method to update an employee by id
    public Employee updateEmployeeById(String id, Employee employee) {
        // Create a query object with the id criteria
        Query query = new Query(Criteria.where("id").is(id));
        // Create an update object with the employee fields
        Update update = new Update();
        update.set("firstName", employee.getFirstName());
        update.set("lastName", employee.getLastName());
        update.set("jobTitle", employee.getJobTitle());
        update.set("department", employee.getDepartment());
        update.set("email", employee.getEmail());
        update.set("phoneNumber", employee.getPhoneNumber());
        update.set("hireDate", employee.getHireDate());
        update.set("salary", employee.getSalary());
        update.set("managerName", employee.getManagerName());
        update.set("officeLocation", employee.getOfficeLocation());
        // Use the findAndModify method of MongoTemplate to update the employee by id and return the updated one
        return mongoTemplate.findAndModify(query, update, Employee.class);
    }

    // Create a method to delete an employee by id
    public void deleteEmployeeById(String id) {
        // Create a query object with the id criteria
        Query query = new Query(Criteria.where("id").is(id));
        // Use the remove method of MongoTemplate to delete the employee by id
        mongoTemplate.remove(query, Employee.class);
    }
}
