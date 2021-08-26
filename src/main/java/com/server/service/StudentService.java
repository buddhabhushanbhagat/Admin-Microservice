package com.server.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.server.model.StudentDomainClass;
import com.server.model.Student;
import com.server.model.Address;

public interface StudentService {
	public StudentDomainClass saveStudentDomain(Student emp,Address addr);
	
	public StudentDomainClass getEmpById(int id);
	
	public List<StudentDomainClass> getAllStudent();
	
	public boolean deleteEmpDomain(int id);
	
	public StudentDomainClass updateEmp(int id,Student emp,Address addr);
}
