package com.bridgelabz.spring_payroll_App.service;


import com.bridgelabz.spring_payroll_App.dto.EmployeeDTO;
import com.bridgelabz.spring_payroll_App.model.Employee;
import org.springframework.stereotype.Service;
@Service
public class EmployeePayrollService {

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        return new Employee(null, employeeDTO.getName(), employeeDTO.getSalary());
    }
}