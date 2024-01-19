package com.kart.employeeManagement.db;

import com.kart.employeeManagement.data.Employee;
import com.kart.employeeManagement.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDBInterface {

    final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

    Employee save(Employee e);

    Employee findById(String id);


    List<Employee> findAll();

    Employee findAndModify(String id, Employee e);


    void deleteEmployeeById(String id);
}