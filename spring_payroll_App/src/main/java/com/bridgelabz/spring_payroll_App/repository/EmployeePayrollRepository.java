package com.bridgelabz.spring_payroll_App.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.spring_payroll_App.model.*;

public interface EmployeePayrollRepository extends JpaRepository<Employee,Integer>{

}