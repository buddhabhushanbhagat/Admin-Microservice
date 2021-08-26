package com.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
public class Address
{
	private int id;
	
	private String houseNum;
	
	private String streetName;
	
	private int pincode;
	
	public Address() {
		super();
	}
	
	public Address(int id,String houseNo,String streetName,int pincode) {
		super();
		this.id=id;
		this.houseNum=houseNo;
		this.streetName=streetName;
		this.pincode=pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
