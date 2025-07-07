package com.project.EM.Admin.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="gender",schema="employee_managment")
@Data
public class GenderEntity {

	@Id
	private Integer id;
	
	private String gender;
}
