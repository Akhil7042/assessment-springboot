package com.asde.springboot.entities;

import org.springframework.stereotype.Repository;

@Repository
public class HospitalBedsData {
	
	String bedType;
	String location;
	Boolean available;
	Integer slots;
	
	public Integer getSlots() {
		return slots;
	}
	public void setSlots(Integer slots) {
		this.slots = slots;
	}
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "HospitalBedsData [bedType=" + bedType + ", location=" + location + ", available=" + available
				+ ", slots=" + slots + "]";
	}


}
