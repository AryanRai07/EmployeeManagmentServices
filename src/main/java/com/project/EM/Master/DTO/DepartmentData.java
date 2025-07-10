package com.project.EM.Master.DTO;

import java.util.List;

import com.project.EM.Master.Entity.DepartmentEntity;

import lombok.Data;

@Data
public class DepartmentData {

	private String msg;
	private Boolean status;
	private List<DepartmentEntity> data;
}
