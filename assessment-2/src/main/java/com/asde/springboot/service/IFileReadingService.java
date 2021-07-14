package com.asde.springboot.service;

import java.util.*;

import com.asde.springboot.entities.HospitalBedsData;

public interface IFileReadingService {
	
	/**
	 * Return the list of beds as read from the csv file provided as the method parameter
	 * @return
	 */
	public List<HospitalBedsData> readBedsData(String location);
	
	/**
	 * Return the list of beds as read from the csv file provided as the method parameter
	 * @param filename
	 * @return
	 */
	public List<HospitalBedsData> readAllBedsData();

	/**
	 * Get the total no of slots for a location as per the bedtype
	 * @param location
	 * @return
	 */
	public Integer getTotalBedsForLocation(String location, String bedType);
}
