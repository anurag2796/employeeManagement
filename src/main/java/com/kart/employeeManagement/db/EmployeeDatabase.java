package com.kart.employeeManagement.db;

import com.kart.employeeManagement.data.Employee;
import com.kart.employeeManagement.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDatabase implements EmployeeDBInterface {

    private final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
    private MongoTemplate mongoTemplate;

    @Autowired
    public EmployeeDatabase(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Employee save(Employee employee) {
        Employee e = mongoTemplate.save(employee);
        logger.info(" DB response  ", e);
        return e;
    }

    @Override
    public Employee findById(String id) {
        return mongoTemplate.findById(id, Employee.class);
    }

    public List<Employee> findAll() {
        return mongoTemplate.findAll(Employee.class);
    }

    public Employee findAndModify(String id, Employee employee) {
        Query query = new Query(Criteria.where("id").is(id));
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
        return mongoTemplate.findAndModify(query, update, Employee.class);
    }

    @Override
    public void deleteEmployeeById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Employee.class);
    }
}