package com.bridgelabz.spring_payroll_App.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

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
    @PatchMapping("/updateSalary/{id}")
    public String updateEmployeeSalary(@PathVariable("id") Long id, @RequestBody String salary) {
        return "Employee with ID " + id + " updated salary to: " + salary;
    }

    @GetMapping("/count")
    public String getEmployeeCount() {
        return "Returning total count of employees!";
    }
}