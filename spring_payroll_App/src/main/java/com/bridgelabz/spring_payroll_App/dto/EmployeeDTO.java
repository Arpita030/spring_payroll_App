package com.bridgelabz.spring_payroll_App.dto;



import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public @ToString class EmployeeDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name must start with uppercase and have at least 3 characters")
    public String name;
	
    @Min(value = 500, message = "Min Wage should be more than 500")
    public long salary;
	
    @Pattern(regexp = "^(male|female)$", message = "Gender must be either 'male' or 'female'")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy") 
    @NotNull(message = "startDate should not be empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    public LocalDate startDate; 

    @NotBlank(message = "Note cannot be empty")
    public String note;

    @NotBlank(message = "Profile picture cannot be empty")
    public String profilePic;

    @NotEmpty(message = "Department should cannot be empty")
    public List<String> departments;
}