package com.project.EM.Admin.Controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.EM.Admin.DTO.EmployeeData;
import com.project.EM.Admin.Dao.EmployeeRepositry;
import com.project.EM.Admin.Entity.EmployeeEntity;


@RestController
public class AdminController {

	
	@Autowired
	EmployeeRepositry empRepo;
	
	@Autowired
	ModelMapper modelMapper ;
	
	@GetMapping("/books")
	public String getBook() {
		return "hello";
	}
	
		@GetMapping("/getEmployeeList")
		public ResponseEntity<EmployeeData> getEmployeeList(){
			EmployeeData res=new EmployeeData();
			List<EmployeeEntity> data=new ArrayList<>();
			try {
				data=empRepo.getAllEmployee();

			    if (data == null || data.isEmpty()) {
			    	res.setMessage("Data Not Available.");
			    	res.setStatus(false);
			    	res.setData(null);
			        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
			    }
			    res.setMessage("Data Available.");
		    	res.setStatus(true);
		    	res.setData(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
		}
		
		public EmployeeData convertToDTO(EmployeeEntity entity) {
		    return modelMapper.map(entity, EmployeeData.class);
		}

		
}
