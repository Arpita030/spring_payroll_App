package com.bridgelabz.spring_payroll_App.service;




import com.bridgelabz.spring_payroll_App.dto.EmployeeDTO;
import com.bridgelabz.spring_payroll_App.exceptions.EmployeeNotFoundException;
import com.bridgelabz.spring_payroll_App.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService {

    private List<Employee> employeeList = new ArrayList<>();

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(Long id) {
        return employeeList.stream()
            .filter(employee -> employee.getId() == id)
            .findFirst()
            .orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
    }

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            return employee;
        }
        return null;
    }

    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(employee -> employee.getId() == id);
    }
}