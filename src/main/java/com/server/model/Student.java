package com.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class Student {
	
	private int studentId;

	private String studentName;
	private String studentCourse;
	private double marks;
	private String emailId;
	private String password;

	public Student() {
		super();
	}

	public Student(int student_id, String studentName, String studentCourse, double marks, String emailId,
			String password) {
		super();
		this.studentId = student_id;
		this.studentName = studentName;
		this.studentCourse = studentCourse;
		this.marks = marks;
		this.emailId = emailId;
		this.password = password;
	}

	public int getStudent_id() {
		return studentId;
	}

	public void setStudent_id(int student_id) {
		this.studentId = student_id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName() {
		this.studentName = studentName;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
