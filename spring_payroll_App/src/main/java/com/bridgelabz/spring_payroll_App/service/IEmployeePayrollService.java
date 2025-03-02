package com.bridgelabz.spring_payroll_App.service;


import com.bridgelabz.spring_payroll_App.dto.EmployeeDTO;
import com.bridgelabz.spring_payroll_App.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    Employee createEmployee(EmployeeDTO employeeDTO);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(long id, EmployeeDTO employeeDTO);
    void deleteEmployee(long id);
}