package com.project.EM.Master.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="department", schema="employee_management")
@Data
public class DepartmentEntity {
	
	@Id
	private Integer id;
	
	@Column(name="name")
	private String departmentName;
}
