package com.bridgelabz.spring_payroll_App;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {
  //  private static final Logger log = LoggerFactory.getLogger(EmployeePayrollApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class, args);
        
        log.info("Employee Payroll App Started in {} Environment", 
            context.getEnvironment().getProperty("environment"));
        
        log.info("Employee Payroll DB User is {}",
            context.getEnvironment().getProperty("spring.datasource.username"));
    }
}