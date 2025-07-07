package com.project.EM.Admin.Entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employee_data", schema="employee_management")
@Data
@Getter
@Setter
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String contact;
	
	@Column(name="dept_id")
	private Integer departmentId;
	
	private Integer gender;
	
	@Column(name="role")
	private Integer roleId;
	
	private String password;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="created_by")
	private Integer createdBy;

}
