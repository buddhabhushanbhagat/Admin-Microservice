package com.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.server.model.Admin;

@Service
public interface AdminService {


	Admin addAdmin(Admin adminObj);

	boolean deleteAdminById(int id);

	Admin updateAdmin(int id, String adminName);

	Admin readAdminById(int id);

	List<Admin> readAllAdmins();


}
