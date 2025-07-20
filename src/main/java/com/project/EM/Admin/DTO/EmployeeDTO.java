package com.project.EM.Admin.DTO;

import jakarta.validation.constraints.*;
import java.util.Date;
import lombok.Data;

@Data
public class EmployeeDTO {

    private Integer employeeId;

    @NotBlank(message = "Employee Name is required")
    private String employeeName;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must start with 6-9 and be exactly 10 digits")
    @NotBlank(message = "Contact No is required")
    private String contactNo;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email Id is required")
    private String emailId;

    @NotNull(message = "Department is required")
    private Integer deptId;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Role is required")
    private String role;

    private Date creartedDate;
}
