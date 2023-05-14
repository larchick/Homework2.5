package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
     Employee getEmployeeWithMaxSalary(Integer departmentId);
    Employee getEmployeeWithMinSalary(Integer departmentId);
    Map<Integer, List<Employee>> getGroupedByDepartmentEmployees(Integer departmentId);
}
