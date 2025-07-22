package com.project.EM.Admin.DTO;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class ProjectDTO {

    private Integer projectId;

    @NotBlank(message = "Project name is required")
    private String projectName;

    @NotBlank(message = "Client name is required")
    private String clientName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date createdDate;
}
