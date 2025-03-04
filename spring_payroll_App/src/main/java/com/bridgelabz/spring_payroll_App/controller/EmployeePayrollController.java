package com.bridgelabz.spring_payroll_App.controller;



import com.bridgelabz.spring_payroll_App.dto.EmployeeDTO;
import com.bridgelabz.spring_payroll_App.dto.ResponseDTO;
import com.bridgelabz.spring_payroll_App.model.Employee;
import com.bridgelabz.spring_payroll_App.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;  

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        System.out.println("Received Employee DTO: " + employeeDTO); // Debugging line
        Employee employee = employeePayrollService.createEmployee(employeeDTO);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeePayrollService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeePayrollService.getEmployeeById(id);
    }
    
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id,@Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeePayrollService.updateEmployee(id, employeeDTO);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable("id") Long id) {
        employeePayrollService.deleteEmployee(id);
        ResponseDTO response = new ResponseDTO("Employee deleted successfully", "Employee ID: " + id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}