package com.asde.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asde.springboot.entities.HospitalBedsData;
import com.asde.springboot.service.IFileReadingService;

@RestController
public class HospitalBedsController {

	@Autowired
	IFileReadingService fileReadingService;
	

	/**
	 * Home page of the application
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String sayHello() {
		return "This is an app that helps you find hospital beds";
	}

	/**
	 * TODO: Fetch the relevant beds data, i.e. the data of all beds
	 *  available with beds Example: returns the total no of beds
	 *  rows that are available in the file for each location
	 */
	@RequestMapping("/getHospitalBeds")
	public List<HospitalBedsData> getHospitalBedsData() {
		return fileReadingService.readAllBedsData();
	}

	/**
	 * TODO: Fetch the relevant beds data based on the parameters passed
	 * by the user Example: return 50 for gurugram and icu
	 */
	@RequestMapping("/getBedsForLocation")
	public Integer getBedsForLocation(@RequestParam(required = true) String location,
			@RequestParam(required = true) String bedType) {
		return fileReadingService.getTotalBedsForLocation(location, bedType);
	}

}
