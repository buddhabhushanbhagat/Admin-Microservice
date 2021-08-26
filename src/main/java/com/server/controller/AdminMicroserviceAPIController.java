package com.server.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.server.model.Address;
import com.server.model.Admin;
import com.server.model.Student;
import com.server.model.StudentDomainClass;
import com.server.service.AdminService;
import com.server.service.StudentService;
 
 

@RestController
@RequestMapping("/adminMicroservice")
public class AdminMicroserviceAPIController {
	@Autowired
	private StudentService service;
	
	@Autowired
	private AdminService adminService;

	
	protected Logger logger = Logger.getLogger(AdminMicroserviceAPIController.class.getName());
	 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Welcome to Admin Microservices Application";
	}
	
	@RequestMapping(value="/add",method= RequestMethod.POST)
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin adminObj)
	{
		Admin admin=adminService.addAdmin(adminObj);
		if(admin !=null)
		{
			return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);
		}
		else
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAdmin(@PathVariable int id) {
		boolean flag = adminService.deleteAdminById(id);
		if (flag == true)
			return new ResponseEntity<Boolean>(flag, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Boolean>(flag, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, consumes = { "application/json" })
	public ResponseEntity<Admin> updateAdmin(@PathVariable int id,@RequestBody ObjectNode obj) {
		String adminName = obj.get("adminName").asText();
		Admin admin = adminService.updateAdmin(id, adminName);
		if (admin!= null)
			return new ResponseEntity<Admin>(admin, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
	}
	@RequestMapping(value = "/read/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable int id) {
		Admin admin = adminService.readAdminById(id);
		if (admin != null)
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		else
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
	}
	@RequestMapping(value = "/readAll")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		List<Admin> list = adminService.readAllAdmins();
		return new ResponseEntity<List<Admin>>(list, HttpStatus.OK);
	}

	
	//============Student Operations==================================
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ResponseEntity<StudentDomainClass> saveData(@RequestBody ObjectNode obj) {
		String studentName = obj.get("name").asText();	
		String studentCourse = obj.get("course").asText();	
		double marks = obj.get("marks").asDouble();	
		String emailId =obj.get("emailId").asText();	
		String password =obj.get("password").asText();
		
		String houseNum=obj.get("houseNumber").asText();
		String streetName=obj.get("street").asText();
		int pincode=obj.get("pincode").asInt();
		
		//float acc_balance=obj.get("acc_balance").floatValue();
		
		Student emp = new Student(123,studentName,studentCourse,marks,emailId,password);
		Address address = new Address(123,houseNum,streetName,pincode);
		StudentDomainClass empDomain=service.saveStudentDomain(emp,address);
		
		if(empDomain==null)
			return new ResponseEntity<StudentDomainClass>(empDomain,HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<StudentDomainClass>(empDomain,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/updateStudent/{id}",method=RequestMethod.PUT)
	public ResponseEntity<StudentDomainClass> updateEmp(@PathVariable Integer id,@RequestBody ObjectNode obj){
//		StudentDomainClass domain=service.updateEmp(id,account);
		StudentDomainClass domain = null;
		if(domain!=null)
		return new ResponseEntity<StudentDomainClass>(domain,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<StudentDomainClass>(domain,HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/deleteStudent/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmp(@PathVariable int id){
		String msg="";
		boolean flag=service.deleteEmpDomain(id);
		if(flag) {
			msg="the student deleted with given id :-"+id;
			return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
		}
		else {
			msg="the student with given id not found";
			return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/getStudentById/{id}")
	public ResponseEntity<StudentDomainClass> getEmp(@PathVariable int id){
		StudentDomainClass domain=service.getEmpById(id);
		if(domain!=null)
			return new ResponseEntity<StudentDomainClass>(domain,HttpStatus.OK);
		else
			return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/getStudents")
	public List<StudentDomainClass> getAll(){
		return service.getAllStudent();
	}
}
