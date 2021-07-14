package com.asde.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.asde.springboot.service.FileReadingServiceImpl;
import com.asde.springboot.service.IFileReadingService;

@SpringBootApplication(scanBasePackages = {"com.asde.springboot"})
public class HospitalBedsApp {
	public static void main(String[] args) {
		SpringApplication.run(HospitalBedsApp.class, args);
	}
	
}