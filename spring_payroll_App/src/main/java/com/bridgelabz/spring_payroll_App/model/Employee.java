package com.bridgelabz.spring_payroll_App.model;
import java.time.LocalDate;
import java.util.List;

import com.bridgelabz.spring_payroll_App.dto.EmployeeDTO;

import lombok.Data;

public @Data class Employee {
	
    private long employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;
    

    public Employee() {}
    
    public Employee(int empId,EmployeeDTO employeedto) {
        this.employeeId=empId;
        this.name=employeedto.getName();
        this.salary=employeedto.getSalary();
        this.gender=employeedto.getGender();
        this.note=employeedto.getNote();
        this.startDate=employeedto.getStartDate();
        this.profilePic=employeedto.getProfilePic();
        this.departments=employeedto.getDepartments();
    }
    
    
}