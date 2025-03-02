package com.bridgelabz.spring_payroll_App.service;



import com.bridgelabz.spring_payroll_App.dto.EmployeeDTO;
import com.bridgelabz.spring_payroll_App.exceptions.EmployeeNotFoundException;
import com.bridgelabz.spring_payroll_App.model.Employee;
import com.bridgelabz.spring_payroll_App.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService{

	@Autowired
	private EmployeePayrollRepository employeeRepository;
    private List<Employee> employeeList = new ArrayList<>();

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = null;
        newEmployee=new Employee(employeeDTO);
        log.debug("Emp Data: "+newEmployee.toString());
        employeeList.add(newEmployee);
        return employeeRepository.save(newEmployee);
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(long id) {
        return employeeList.stream()
                .filter(employee -> employee.getEmployeeId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with ID: " + id));
    }

    public Employee updateEmployee(long id, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(id); 

        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setDepartments(employeeDTO.getDepartments());

        log.info("Updated Employee: {}", employee);
        return employee;
    }

    public void deleteEmployee(long id) {
        boolean removed = employeeList.removeIf(employee -> employee.getEmployeeId() == id);
        if (!removed) {
            throw new EmployeeNotFoundException("Cannot delete. Employee Not Found with ID: " + id);
        }
        log.info("Deleted Employee with ID: {}", id);
    }
}