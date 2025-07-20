package com.project.EM.Admin.DTO;


import com.project.EM.Admin.Entity.EmployeeEntity;

import lombok.Data;


@Data
public class EmployeeData {
	
	private String msg;
	private Boolean status;
	private EmployeeEntity data;

}
