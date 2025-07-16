package com.project.EM.Master.Repository;

import com.project.EM.Master.Entity.ChildDepartmentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChildDepartmentRepository extends CrudRepository<ChildDepartmentEntity,Integer> {

    @Query("select s from ChildDepartmentEntity s where s.parentDepartmentId= :id")
     List<ChildDepartmentEntity> findByParentId(Integer id);
}
