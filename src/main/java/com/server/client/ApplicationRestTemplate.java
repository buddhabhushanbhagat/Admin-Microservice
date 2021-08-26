package com.server.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.server.model.Address;
import com.server.model.Student;
//
//import reactor.core.publisher.Mono;

@Component
public class ApplicationRestTemplate {
	@Autowired
	   RestTemplate restTemplate;
	public Student saveEmp(Student emp) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Student> entity = new HttpEntity<Student>(emp, headers);

		return restTemplate.exchange("http://StudentMicroserviceApp/student/add", HttpMethod.POST, entity, Student.class)
				.getBody();
	}

	public Address saveAddress(Address address) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Address> entity = new HttpEntity<Address>(address, headers);
		return restTemplate.exchange("http://StudentAddressMicroserviceApp/address/add", HttpMethod.POST, entity, Address.class)
				.getBody();
	}

	public Student getEmpById(int id) {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <Student> entity = new HttpEntity<Student>(headers);
	      System.out.println("before response");
	      Student emp = restTemplate.exchange("http://StudentMicroserviceApp/student/get/"+id, HttpMethod.GET, entity, Student.class).getBody();
	      System.out.println("after response: "+ emp);
	      return emp;
	 
	}
	
	public Address getAddressById(int id) {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <Address> entity = new HttpEntity<Address>(headers);
	      return restTemplate.exchange("http://StudentAddressMicroserviceApp/address/read/"+id, HttpMethod.GET, entity, Address.class).getBody();
	}

	public boolean deleteAddress(int id) {
		// TODO Auto-generated method stub
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <Address> entity = new HttpEntity<Address>(headers);
	      return restTemplate.exchange("http://StudentAddressMicroserviceApp/address/delete/"+id, HttpMethod.DELETE, entity, Boolean.class).getBody();

	}

	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <Student> entity = new HttpEntity<Student>(headers);
	      return restTemplate.exchange("http://StudentMicroserviceApp/student/delete/"+id, HttpMethod.DELETE, entity, Boolean.class).getBody();

	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <Student> entity = new HttpEntity<Student>(headers);
	      List<Student> studentList = Arrays.asList(restTemplate.getForEntity("http://StudentMicroserviceApp/student/getAll/", Student[].class).getBody());
	      return studentList;
	}

}
