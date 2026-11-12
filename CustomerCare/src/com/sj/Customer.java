package com.sj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Customer {
	@Value("someCustomer")
	String name;
	
	@Autowired
	//@Qualifier("c123")
	Complaint complaint;
	
	
	public void registerMajorOrMinor() {
		complaint.register();
	}
	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}
	
	
	

}
