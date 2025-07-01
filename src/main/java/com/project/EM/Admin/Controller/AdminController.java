package com.project.EM.Admin.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.EM.Admin.Dao.AdminRepositry;
import com.project.EM.Admin.Entity.Product;


@RestController
public class AdminController {
	
	@Autowired
	AdminRepositry admRepo;
	
	@GetMapping("/books")
	public String getBook() {
		return "hello";
	}
	
	//All User List
		@GetMapping("/user")
		public ResponseEntity<List<Product>> getAllUSer() {
			List<Product> data=new ArrayList<Product>();
			try {
				data=admRepo.getAllUser();
				if(data.size()>0) {
					return new ResponseEntity<List<Product>>(data,HttpStatus.OK);
					//return ResponseEntity.of(Optional.of(data));    // we can write like this also of the help of Of() method
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
}
