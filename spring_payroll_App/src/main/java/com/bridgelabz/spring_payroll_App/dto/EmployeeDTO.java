package com.bridgelabz.spring_payroll_App.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data  // Generates Getters, Setters, toString, equals, and hashCode
public class EmployeeDTO {
    private String name;
    private double salary;
    
}
