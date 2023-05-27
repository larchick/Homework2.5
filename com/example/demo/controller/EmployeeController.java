package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.validator.EmployeeValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer salary, @RequestParam Integer departmentId) {
        if (EmployeeValidator.validate(firstName, lastName)) {
            return ResponseEntity.ok(service.addEmployee(firstName, lastName, salary, departmentId));
        }else {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }
}