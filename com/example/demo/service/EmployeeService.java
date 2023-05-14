package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> findAll();

    abstract Map<String, Employee> getAllEmployees();

}