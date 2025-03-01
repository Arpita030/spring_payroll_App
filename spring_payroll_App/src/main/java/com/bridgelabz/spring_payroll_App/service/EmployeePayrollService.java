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
    private int employeeIdCounter = 1; 


    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(employeeIdCounter++, employeeDTO);
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(Long id) {
        return employeeList.stream()
            .filter(employee -> employee.getEmployeeId() == id)
            .findFirst()
            .orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
    }

    public Employee updateEmployee(long id, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            employee.setGender(employeeDTO.getGender());
            employee.setStartDate(employeeDTO.getStartDate());
            employee.setNote(employeeDTO.getNote());
            employee.setProfilePic(employeeDTO.getProfilePic());
            employee.setDepartments(employeeDTO.getDepartment());
        }
        return employee;
    }
    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(employee -> employee.getEmployeeId() == id);
    }
}