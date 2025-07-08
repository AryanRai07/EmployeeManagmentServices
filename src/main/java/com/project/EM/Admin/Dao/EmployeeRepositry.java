package com.project.EM.Admin.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.EM.Admin.Entity.EmployeeEntity;

public interface EmployeeRepositry extends CrudRepository<EmployeeEntity, Integer> {
	
	@Query("select e from EmployeeEntity e")
	List<EmployeeEntity> getAllEmployee();
	
	@Query("select e from EmployeeEntity e where e.name= :userName and e.password= :password ")
	EmployeeEntity userLoginData(String userName, String password);

}
