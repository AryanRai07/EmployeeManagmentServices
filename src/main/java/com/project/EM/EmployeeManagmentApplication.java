package com.project.EM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication   
public class EmployeeManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagmentApplication.class, args);
		System.out.println("-------------------Start--------------------");
	}

}

//No need to use ComponentScan("") because all package is inside com.project.EM this package if package is 
//outside of it then need to give package name both or like this 

//@ComponentScan(basePackages = {
//"com.project.EM",                      // base package
//"com.project.Admin",               // need 
//"com.project.EM.Employee"             // NO need optional
//})
