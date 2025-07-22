package com.project.EM.Admin.DTO;


import jakarta.validation.constraints.*;

import java.util.Date;

public class ProjectDTO {

    private Integer projectId;

    @NotBlank(message = "Project name is required")
    private String projectName;

    @NotBlank(message = "Client name is required")
    private String clientName;

    //@NotEmpty(message = "Start Date is required")
    private Date startDate;

    @NotNull(message = "Lead by employee is required")
    private Integer leadByEmpId;

    @NotBlank(message = "Contact person is required")
    private String contactPerson;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must start with 6-9 and be exactly 10 digits")
    @NotBlank(message = "Contact No is required")
    private String contactNo;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email Id is required")
    private String emailId;

    private Integer createdBy;

    private Date createdDate;
}
