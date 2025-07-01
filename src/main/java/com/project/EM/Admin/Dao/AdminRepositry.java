package com.project.EM.Admin.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.EM.Admin.Entity.Product;

public interface AdminRepositry extends CrudRepository<Product, Integer> {

	@Query("Select p from Product p")
	List<Product> getAllUser();


	

}
