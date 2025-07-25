package com.project.EM.Admin.Repository;

import com.project.EM.Admin.Entity.ProjectEmpMappingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectEmpMappingRepositry extends CrudRepository<ProjectEmpMappingEntity,Integer> {

    @Query("select p from ProjectEmpMappingEntity p ")
    List<ProjectEmpMappingEntity> getAllEmployee();

}
