package com.bridgelabz.spring_payroll_App.service;


import com.bridgelabz.spring_payroll_App.dto.EmployeeDTO;
import com.bridgelabz.spring_payroll_App.model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeePayrollService {

    private final Map<Long, Employee> employeeMap = new HashMap<>();
    private Long nextId = 1L;

    public String getAllEmployees() {
        return "Returning all employees: " + employeeMap.values();
    }

    public String getEmployeeById(Long id) {
        Employee employee = employeeMap.get(id);
        return (employee != null) ? employee.toString() : "Employee not found!";
    }

    public String createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(nextId, employeeDTO.getName(), employeeDTO.getSalary());
        employeeMap.put(nextId, newEmployee);
        nextId++;
        return "Employee created: " + newEmployee;
    }

    public String updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeMap.get(id);
        if (existingEmployee != null) {
            existingEmployee.setName(employeeDTO.getName());
            existingEmployee.setSalary(employeeDTO.getSalary());
            return "Employee updated: " + existingEmployee;
        }
        return "Employee not found!";
    }

    public String deleteEmployee(Long id) {
        if (employeeMap.containsKey(id)) {
            employeeMap.remove(id);
            return "Employee with ID " + id + " deleted.";
        }
        return "Employee not found!";
    }
}
