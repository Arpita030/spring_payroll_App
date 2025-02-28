package com.bridgelabz.spring_payroll_App.controller;



import com.bridgelabz.spring_payroll_App.dto.EmployeeDTO;
import com.bridgelabz.spring_payroll_App.model.Employee;
import com.bridgelabz.spring_payroll_App.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;  

    @PostMapping("/create")
    public Employee createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeePayrollService.createEmployee(employeeDTO);
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
    public Employee updateEmployee(@PathVariable("id") Long id,@Valid  @RequestBody EmployeeDTO employeeDTO) {
        return employeePayrollService.updateEmployee(id, employeeDTO);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        boolean isDeleted = employeePayrollService.deleteEmployee(id);
        if(isDeleted) {
        	return "Employee deleted  Successfully";
        }
        return "Employee not found";
    }

}