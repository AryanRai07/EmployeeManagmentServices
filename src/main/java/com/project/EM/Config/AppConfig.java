package com.project.EM.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.EM.Admin.Repository.EmployeeRepositry;
import com.project.EM.Master.Repository.DepartmentRepository;

@Configuration
public class AppConfig {
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
