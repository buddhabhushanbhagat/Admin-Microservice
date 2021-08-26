package com.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.server.client.ApplicationRestTemplate;
import com.server.model.Address;
import com.server.model.Student;
import com.server.model.StudentDomainClass;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private ApplicationRestTemplate restTemplate;
	
	@Override
	public StudentDomainClass saveStudentDomain(Student emp, Address address) {
		// TODO Auto-generated method stub
		//Calling student and address API
		Address addressObj=restTemplate.saveAddress(address);
		Student empObj=restTemplate.saveEmp(emp);
		
		if(empObj == null || addressObj == null)
			return null;
		
		StudentDomainClass domainObj=new StudentDomainClass(empObj,addressObj);
		return domainObj;
	}

	@Override
	public List<StudentDomainClass> getAllStudent() {
		// TODO Auto-generated method stub
		List<StudentDomainClass> domainList=new ArrayList<StudentDomainClass>();
		List<Student> studentList=restTemplate.getAllStudent();
		StudentDomainClass domain=null;
		for(Student student: studentList ) {
			domain=new StudentDomainClass();
			domain.setEmployee(student);
			domain.setAddress(restTemplate.getAddressById(student.getStudent_id()));
			domainList.add(domain);
		}
		return domainList;
	}

	@Override
	public boolean deleteEmpDomain(int id) {
		// TODO Auto-generated method stub
		boolean isAddressDeleted = restTemplate.deleteAddress(id);
		boolean isEmployeeDeleted = restTemplate.deleteEmployee(id);
		if(isAddressDeleted==false||isEmployeeDeleted==false)
			return false;
		return true;
	}


	@Override
	public StudentDomainClass getEmpById(int id) {
		// TODO Auto-generated method stub
		Student empObj=restTemplate.getEmpById(id);
		Address addObj=restTemplate.getAddressById(id);
		
		if(empObj==null||addObj==null)
			return null;
		
		StudentDomainClass domain=new StudentDomainClass(empObj,addObj);
		return domain;
	}

	@Override
	public StudentDomainClass updateEmp(int id, Student emp, Address addr) {
		// TODO Auto-generated method stub
		return null;
	}

}
