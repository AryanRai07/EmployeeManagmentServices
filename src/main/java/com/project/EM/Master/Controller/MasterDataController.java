package com.project.EM.Master.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.EM.Master.DTO.DepartmentData;
import com.project.EM.Master.Entity.DepartmentEntity;
import com.project.EM.Master.Repository.DepartmentRepository;

@RestController
public class MasterDataController {
	
	private final DepartmentRepository depRepo;

    public MasterDataController(DepartmentRepository employeeRepository) {
        this.depRepo = employeeRepository;
    }
    
    @GetMapping("/getDepartmentList")
    public ResponseEntity<DepartmentData> departmentList(){
    	DepartmentData res=new DepartmentData();
    	List<DepartmentEntity> list=new  ArrayList<>();
    	try {
    		list=depRepo.getDepartmentList();
    		if(list == null || list.isEmpty()) {
    			res.setStatus(false);
    			res.setMsg("No Department Available");
    			res.setData(null);
    			return new ResponseEntity<>(res,HttpStatus.OK);
    		}
    		res.setStatus(true);
    		res.setMsg("Department list availabel.");
    		res.setData(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return new ResponseEntity<>(res,HttpStatus.OK);
    }


}
