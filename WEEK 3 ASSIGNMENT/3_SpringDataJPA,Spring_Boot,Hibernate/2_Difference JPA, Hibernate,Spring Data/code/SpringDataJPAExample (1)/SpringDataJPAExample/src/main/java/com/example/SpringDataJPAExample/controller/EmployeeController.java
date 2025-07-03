package com.example.SpringDataJPAExample.controller;
import com.example.SpringDataJPAExample.EmployeeService;
import com.example.SpringDataJPAExample.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "Employee added successfully!";
    }
    @GetMapping("/")
    public String home() {
        return "✅ Spring Boot is running! Go to /api/employees for the REST API.";
    }
}
