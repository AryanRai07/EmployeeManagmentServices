package com.project.EM.Admin.DTO;

import java.util.List;

import com.project.EM.Admin.Entity.EmployeeEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeData {
	
	private String message;
	private Boolean status;
	private List<EmployeeEntity> data;

}
