package com.bridgelabz.spring_payroll_App.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    private Map<Integer, Map<String, Object>> employeeData = new HashMap<>();

    // Default message
    @GetMapping("/")
    public String home() {
        return "Employee Payroll Service is running!";
    }

    // Get Employee by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable int id) {
        if (employeeData.containsKey(id)) {
            return ResponseEntity.ok(employeeData.get(id));
        } else {
            return ResponseEntity.status(404).body("Employee not found!");
        }
    }

    // Create Employee
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody Map<String, Object> employee) {
        int id = employeeData.size() + 1;
        employeeData.put(id, employee);
        return ResponseEntity.ok("Employee added with ID: " + id);
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Map<String, Object> employee) {
        if (employeeData.containsKey(id)) {
            employeeData.put(id, employee);
            return ResponseEntity.ok("Employee updated with ID: " + id);
        } else {
            return ResponseEntity.status(404).body("Employee not found!");
        }
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        if (employeeData.containsKey(id)) {
            employeeData.remove(id);
            return ResponseEntity.ok("Employee deleted with ID: " + id);
        } else {
            return ResponseEntity.status(404).body("Employee not found!");
        }
    }
}
