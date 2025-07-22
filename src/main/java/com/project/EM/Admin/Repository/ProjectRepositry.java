package com.project.EM.Admin.Repository;

import com.project.EM.Admin.Entity.ProjectEntity;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositry extends CrudRepository<ProjectEntity,Integer> {

	@Query("select p from ProjectEntity p")
	List<ProjectEntity> getAllProjectData();


}
