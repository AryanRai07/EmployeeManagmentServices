package com.project.EM.Master.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.EM.Master.Entity.DepartmentEntity;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Integer> {

	@Query("Select d from DepartmentEntity d")
	List<DepartmentEntity> getDepartmentList();

}
