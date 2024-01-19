package com.kart.employeeManagement.data;

import com.kart.employeeManagement.constant.Department;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Data
public class Employee implements Comparable<Employee> {
    private String id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private Department department;
    private String email;
    private List<String> phoneNumber;
    private String hireDate;
    private double salary;
    private String managerName;
    private String officeLocation;

    // Constructor
    public Employee(String id, String firstName, String lastName, String jobTitle,
                    Department department, String email, List<String> phoneNumber,
                    String hireDate, double salary, String managerName, String officeLocation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.managerName = managerName;
        this.officeLocation = officeLocation;
    }

    public Employee() {
        this.id = "";
        this.firstName = "";
        this.lastName = "";
        this.jobTitle = "";
        this.department = Department.BENCH;
        this.email = "";
        this.phoneNumber = Arrays.asList("", "");
        this.hireDate = "";
        this.salary = 0.0;
        this.managerName = "";
        this.officeLocation = "";
    }
    // Getters and setters for all fields (omitted for brevity)

    // Comparable implementation: Sort by ID in ascending order
    @Override
    public int compareTo(Employee other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return

                "Employee{" +
                        "id='" + id + '\'' +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", jobTitle='" + jobTitle + '\'' +
                        ", department=" + department +
                        ", email='" + email + '\'' +
                        ", phoneNumber=" + phoneNumber +
                        ", hireDate='" + hireDate + '\'' +
                        ", salary=" + salary +
                        ", managerName='" + managerName + '\'' +
                        ", officeLocation='" + officeLocation + '\'' +
                        '}';
    }
    // Comparators for alternative sorting:

    public static class SalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            return Double.compare(e1.salary, e2.salary); // Sort by salary
        }
    }

    public static class NameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            int lastNameComparison = e1.lastName.compareTo(e2.lastName);
            if (lastNameComparison != 0) {
                return lastNameComparison;
            } else {
                return e1.firstName.compareTo(e2.firstName); // Sort by last name, then first name
            }
        }
    }
}

