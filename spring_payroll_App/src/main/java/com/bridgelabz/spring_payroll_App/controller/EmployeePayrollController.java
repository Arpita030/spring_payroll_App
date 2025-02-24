package com.bridgelabz.spring_payroll_App.controller;

import com.bridgelabz.spring_payroll_App.service.EmployeePayrollService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
     
	
	@Autowired
    private EmployeePayrollService employeeService;

    @GetMapping("/")
    public String getAllEmployees() {
        return "Getting all employees!";
    }

    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable("id") Long id) {
        return "Getting employee with ID: " + id;
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody String employee) {
        return "Employee created: " + employee;
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody String employee) {
        return "Employee updated with details: " + employee;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        return "Employee with ID " + id + " deleted.";
    }
    
}