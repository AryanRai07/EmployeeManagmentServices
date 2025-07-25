package com.project.EM.Admin.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="project_emp_mapping", schema = "employee_management")
@Data
public class ProjectEmpMappingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_emp_mapping_id")
    private Integer projEmpMappingId;

    @Column(name="project_id")
    private Integer projectId;

    @Column(name = "emp_id")
    private Integer empId;

    @Column(name="assigned_data")
    private Date assignedData;

    @Column(name="role")
    private String role;

    @Column(name="is_active")
    private boolean isActive;


}
