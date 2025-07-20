package com.project.EM.Master.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.project.EM.Master.DTO.APIResponce;
import com.project.EM.Master.Entity.ChildDepartmentEntity;
import com.project.EM.Master.Repository.ChildDepartmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.EM.Master.Entity.DepartmentEntity;
import com.project.EM.Master.Repository.DepartmentRepository;

@RestController
public class MasterDataController {
	
	private final DepartmentRepository depRepo;

	private final ChildDepartmentRepository childDepRepo;


    public MasterDataController(DepartmentRepository employeeRepository, ChildDepartmentRepository childDepRepo) {
        this.depRepo = employeeRepository;
		this.childDepRepo=childDepRepo;
    }
    
    @GetMapping("/getDepartmentList")
    public ResponseEntity<APIResponce<DepartmentEntity>> departmentList(){
    	List<DepartmentEntity> list=new  ArrayList<>();
    	try {
    		list=depRepo.getDepartmentList();
    		if(list == null || list.isEmpty()) {
    			return new ResponseEntity<>(new APIResponce<>(false,"No Department Available",null),HttpStatus.NOT_FOUND);
    		}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new APIResponce<>(false,"Internal Server Error",null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	return new ResponseEntity<>(new APIResponce<>(true,"Data fetched successfully.",list),HttpStatus.OK);


	}

	@GetMapping("/childDepartment/{parentDepartmentId}")
	public ResponseEntity<APIResponce<ChildDepartmentEntity>> getChildDepartmentList(
			@PathVariable("parentDepartmentId") Integer id){
		List<ChildDepartmentEntity> data=new ArrayList<>();
		try {
			data=childDepRepo.findByParentId(id);
			if(data == null || data.isEmpty()) {
				return new ResponseEntity<>(new APIResponce<>(false,"No Department Available",data),HttpStatus.NOT_FOUND);
			}
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(new APIResponce<>(false,"Internal Server Error.",data),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new APIResponce<>(true,"Data fetched successfully.",data),HttpStatus.OK);

	}


}
