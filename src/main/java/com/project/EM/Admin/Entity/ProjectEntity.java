package com.project.EM.Admin.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="project_data", schema="employee_management")
@Data
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name="project_name")
    private String projectName;

    @Column(name="client_name")
    private String clientName;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="lead_by_emp_id")
    private Integer leadByEmpId;

    @Column(name="contact_person")
    private String contactPerson;

    @Column(name="contact_no")
    private String contactNo;

    @Column(name="email_id")
    private String emailId;

    @Column(name="created_by")
    private Integer createdBy;

    @Column(name="created_on")
    private Date createdDate;

}
