package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getGroupedByDepartmentEmployees(
            @RequestParam(name = "departmentId", required = false) Integer departmentId
    ) {
        return departmentService.getGroupedByDepartmentEmployees(departmentId);
    }

}
