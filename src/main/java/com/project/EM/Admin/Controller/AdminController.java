package com.project.EM.Admin.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.project.EM.Admin.DTO.ProjectDTO;
import com.project.EM.Admin.Entity.ProjectEntity;
import com.project.EM.Admin.Repository.ProjectRepositry;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.project.EM.Admin.DTO.EmployeeDTO;
import com.project.EM.Admin.DTO.EmployeeData;
import com.project.EM.Admin.DTO.LoginRequest;
import com.project.EM.Admin.Entity.EmployeeEntity;
import com.project.EM.Admin.Repository.EmployeeRepositry;
import com.project.EM.Master.DTO.APIResponce;

import jakarta.validation.Valid;
import org.springframework.web.client.RestClient;


@RestController
public class AdminController {

	
	@Autowired
	EmployeeRepositry empRepo;

	@Autowired
	ProjectRepositry prjRepo;
	
	@Autowired
	ModelMapper modelMapper ;
	
	@GetMapping("/books")
	public String getBook() {
		return "hello";
	}
	
		@GetMapping("/getEmployeeList")
		public ResponseEntity<APIResponce<EmployeeEntity>> getEmployeeList(){
			List<EmployeeEntity> data=new ArrayList<>();
			try {
				data=empRepo.getAllEmployee();

			    if (data == null || data.isEmpty()) {
			        return new ResponseEntity<>(new APIResponce<>(false, "Data Not Available.", null), HttpStatus.NOT_FOUND);
			    }
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(new APIResponce<>(false,"Internal Server Error.",null),HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(new APIResponce<>(true, "Data Available.", data),HttpStatus.OK);
		}
		
		@PostMapping("login")
		public ResponseEntity<EmployeeData> loginData(@RequestBody LoginRequest request){
			EmployeeData res=new EmployeeData();
			EmployeeEntity data =new EmployeeEntity();
			try {
				data=empRepo.userLoginData(request.getUserName(),request.getPassword());
				if(data == null) {
					res.setMsg("Invalid credentials or user not found.");
			    	res.setStatus(false);
			    	res.setData(null);
			        return new ResponseEntity<>(res,HttpStatus.OK);
				}
				res.setMsg("Login Succesfull.");
				res.setStatus(true);
				res.setData(data);
			} catch (Exception e) {
				e.printStackTrace();
				res.setMsg("Server error occurred.");
		        res.setStatus(false);
		        res.setData(null);
		        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(res,HttpStatus.OK);
		}
		
		@PostMapping("/saveData")
		public ResponseEntity<APIResponce<String>> saveEmployeeData(@Valid @RequestBody EmployeeDTO data, BindingResult br ){
			EmployeeEntity obj=new EmployeeEntity();
			String saveData=null;
			try {
				
				 if(br.hasErrors()) { List<String>
				 errorMsg=br.getFieldErrors().stream().map(e->
				 e.getField()+":"+e.getDefaultMessage()).collect(Collectors.toList());
				 APIResponce<String> responce=new APIResponce<String>(false,
				 "Validation failed", errorMsg); return new
				 ResponseEntity<APIResponce<String>>(responce,HttpStatus.OK); }
				 
			 	
			 obj.setName(data.getEmployeeName());
			 obj.setEmail(data.getEmailId());
			 obj.setContact(data.getContactNo());
			 obj.setDepartmentId(data.getDeptId());
			 obj.setGender(1);
			 obj.setPassword(data.getPassword());
			 obj.setCreatedBy(1);
			 obj.setCreatedOn(new Date());
			 obj.setRoleId(1);
			 obj=empRepo.save(obj);
			  saveData=obj.toString();
			 return new ResponseEntity<>(new APIResponce<>(true, "Data saved Succesfully", saveData),HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(new APIResponce<>(false,"Internal Server Error.",saveData),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("deleteEmploye/{id}")
		public ResponseEntity<APIResponce<EmployeeDTO>> deleteData(@PathVariable Integer id) {
			try {
				if(id== null) {
					return new ResponseEntity<>(new APIResponce<>(false,"Employee Id required", null),HttpStatus.BAD_REQUEST);
				}
				else {
					Boolean exist=empRepo.existsById(id);
					if(exist) {
						empRepo.deleteById(id);
						return new ResponseEntity<>(new APIResponce<>(true,"Employee deleted succesfully", null),HttpStatus.OK);
					}else {
						return new ResponseEntity<>(new APIResponce<>(false,"Employee Id not exist", null),HttpStatus.NOT_FOUND);
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(new APIResponce<>(false,"Internal Server Error", null),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping("/updateEmployeee/{id}")
		public ResponseEntity<APIResponce<String>> updateEmployee(@PathVariable Integer id, 
				@Valid @RequestBody EmployeeDTO data, BindingResult br ){
			EmployeeEntity obj=new EmployeeEntity();
			String saveData=null;
			try {
			 if(br.hasErrors()) { List<String>
			 errorMsg=br.getFieldErrors().stream().map(e->
			 e.getField()+":"+e.getDefaultMessage()).collect(Collectors.toList());
			 APIResponce<String> responce=new APIResponce<String>(false,
			 "Validation failed", errorMsg); return new
			 ResponseEntity<APIResponce<String>>(responce,HttpStatus.OK); }
			 
			 if(id== null) {
					return new ResponseEntity<>(new APIResponce<>(false,"Employee Id required", null),HttpStatus.BAD_REQUEST);
				}
				else {
					Boolean exist=empRepo.existsById(id);
					if(exist) {
						 obj.setId(id);
						 obj.setName(data.getEmployeeName());
						 obj.setEmail(data.getEmailId());
						 obj.setContact(data.getContactNo());
						 obj.setDepartmentId(data.getDeptId());
						 obj.setGender(1);
						 obj.setPassword(data.getPassword());
						 obj.setCreatedBy(1);
						 obj.setCreatedOn(new Date());
						 obj.setRoleId(1);
						 obj=empRepo.save(obj);
						  saveData=obj.toString();
						return new ResponseEntity<>(new APIResponce<>(true,"Employee updated succesfully", saveData),HttpStatus.OK);
					}else {
						return new ResponseEntity<>(new APIResponce<>(false,"Employee Id "+id+" not exist", null),HttpStatus.NOT_FOUND);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(new APIResponce<>(false,"Internal Server Error", null),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		@PostMapping("/createProject")
		public ResponseEntity<APIResponce<String>> createProject(@Valid @RequestBody ProjectDTO data, BindingResult br){
			ProjectEntity projectData=new ProjectEntity();
			List<String> errors=null;
			try {
				if(br.hasErrors()){
					 errors=br.getFieldErrors().stream().map(e->e.getField()+":"+e.getDefaultMessage()).collect(Collectors.toList());
					return new ResponseEntity<>(new APIResponce<String>(false,"validation failed",errors),HttpStatus.BAD_REQUEST);
				}
				 projectData=modelMapper.map(data,ProjectEntity.class);
				projectData=prjRepo.save(projectData);
				String returnData=projectData.toString();
				return new ResponseEntity<>(new APIResponce<String>(true,"Project created Succesfully",returnData),HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(new APIResponce<>(false,"Internal Server Error",errors),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/projectData")
		public ResponseEntity<APIResponce<ProjectEntity>> getAllProjectData(){
			List<ProjectEntity> data=new ArrayList<>();
			List<ProjectDTO> resData=new ArrayList<>();
			try {
				data=prjRepo.getAllProjectData();
				//resData=(List<ProjectDTO>) modelMapper.map(data, ProjectDTO.class);
			    if (data == null || data.isEmpty()) {
			        return new ResponseEntity<>(new APIResponce<>(false, "Data Not Available.", null), HttpStatus.NOT_FOUND);
			    }
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(new APIResponce<>(false,"Internal Server Error.",null),HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(new APIResponce<>(true, "Data Available.", data),HttpStatus.OK);
		}

		@PutMapping("/updateProject/{id}")
		public ResponseEntity<APIResponce<String>> updateProject(@PathVariable Integer id, @Valid @RequestBody ProjectDTO data, BindingResult br){
			String returnResponce=null;
			try {
				if(br.hasErrors()){
					List<String>errorMsg= br.getFieldErrors().stream().map(e->e.getField()+":"+e.getDefaultMessage()).collect(Collectors.toList());

					APIResponce<String> responce=new APIResponce<String>(false, "Validation failed", errorMsg);
					return new ResponseEntity<APIResponce<String>>(responce,HttpStatus.OK);
				}
				if(data.getProjectId() == 0){
					return new ResponseEntity<>(new APIResponce<String>(false,"Project id can not be null",returnResponce),HttpStatus.NOT_FOUND);
				}else{
					Boolean exist=prjRepo.existsById(id);
					if(exist) {
						ProjectEntity saveData=modelMapper.map(data,ProjectEntity.class);

						saveData=prjRepo.save(saveData);
						returnResponce=saveData.toString();
						return new ResponseEntity<>(new APIResponce<>(true,"Project updated succesfully", returnResponce),HttpStatus.OK);
					}else {
						return new ResponseEntity<>(new APIResponce<>(false,"Project Id "+id+" not exist", null),HttpStatus.NOT_FOUND);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(new APIResponce<>(false,"Internal Server Error.",null),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	@DeleteMapping("deleteProject/{id}")
	public ResponseEntity<APIResponce<ProjectDTO>> deleteProject(@PathVariable Integer id) {
		try {
			if(id== null) {
				return new ResponseEntity<>(new APIResponce<>(false,"Project Id required", null),HttpStatus.BAD_REQUEST);
			}
			else {
				Boolean exist=prjRepo.existsById(id);
				if(exist) {
					prjRepo.deleteById(id);
					return new ResponseEntity<>(new APIResponce<>(true,"Project deleted succesfully", null),HttpStatus.OK);
				}else {
					return new ResponseEntity<>(new APIResponce<>(false,"Project Id not exist", null),HttpStatus.NOT_FOUND);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new APIResponce<>(false,"Internal Server Error", null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
}
