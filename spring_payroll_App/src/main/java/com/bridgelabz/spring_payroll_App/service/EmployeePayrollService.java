package com.bridgelabz.spring_payroll_App.service;


import com.bridgelabz.spring_payroll_App.dto.EmployeeDTO;
import com.bridgelabz.spring_payroll_App.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeePayrollService {

    private final List<Employee> employeeList = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1); // Auto-incrementing ID

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    // Create a new employee
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(idGenerator.getAndIncrement(), employeeDTO.getName(), employeeDTO.getSalary());
        employeeList.add(newEmployee);
        return newEmployee;
    }

    // Update an existing employee
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = getEmployeeById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            return employee;
        }
        return null; // Employee not found
    }

    // Delete an employee by ID
    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(employee -> employee.getId().equals(id));
    }
}
