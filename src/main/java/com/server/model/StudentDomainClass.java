package com.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

 //Wrapper Class for Employee,Address and Account
public class StudentDomainClass {
	
	private Student student;		 
	private Address address;	
	
	public StudentDomainClass(Student student, Address address) {
		super();
		this.student = student;
		this.address = address;
	}

	public Student getEmployee() {
		return student;
	}

	public void setEmployee(Student student) {
		this.student = student;
	}

	
	
	public StudentDomainClass() {
		System.out.println("CustomerDomainClass default ");
	}

	public StudentDomainClass(Address address, Student studentObj) {
		System.out.println("CustomerDomainClass account and address()");
		this.student = studentObj;
		this.address = address;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	 

}
