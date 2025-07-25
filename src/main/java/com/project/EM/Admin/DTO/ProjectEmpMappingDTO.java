package com.project.EM.Admin.DTO;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
@Data
public class ProjectEmpMappingDTO {

    private Integer projEmpMappingId;
    private Integer projectId;
    private Integer empId;
    private Date assignedData;
    private String role;
    private boolean isActive;

}
