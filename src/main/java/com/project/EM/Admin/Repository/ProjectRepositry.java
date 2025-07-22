package com.project.EM.Admin.Repository;

import com.project.EM.Admin.Entity.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositry extends CrudRepository<ProjectEntity,Integer> {


}
