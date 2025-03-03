package com.bridgelabz.spring_payroll_App.model;
import java.time.LocalDate;
import java.util.List;

import com.bridgelabz.spring_payroll_App.dto.EmployeeDTO;

import lombok.Data;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


public @Data class Employee {
	
    private long employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    
    
    @ElementCollection
    @CollectionTable(name="employee_department", joinColumns=@JoinColumn(name="id"))
    @Column(name="department")
    private List<String> departments;
    

    public Employee() {}
    

    public Employee(EmployeeDTO employeedto) {
    	this.updateEmployee(employeedto);
    }
    
    public void updateEmployee(EmployeeDTO employeedto) {
    	this.name=employeedto.name;
        this.salary=employeedto.salary;
        this.gender=employeedto.gender;
        this.note=employeedto.note;
        this.startDate=employeedto.startDate;
        this.profilePic=employeedto.profilePic;
        this.departments=employeedto.departments;
    }
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