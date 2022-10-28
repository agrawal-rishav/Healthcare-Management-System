package com.HMS.HealthCare;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.HMS.HealthCare.Entity.Admin;
import com.HMS.HealthCare.Repository.AdminRepository;

@SpringBootApplication
public class HealthCareApplication {

	@Autowired
	private AdminRepository adminRepository;


	public static void main(String[] args) {
		SpringApplication.run(HealthCareApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return() -> {
			adminRepository.save(new Admin("admin1", "12345678"));
			adminRepository.save(new Admin("admin2", "87654321"));
		};
	}


}
