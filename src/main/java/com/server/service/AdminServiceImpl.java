package com.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.server.adminDao.AdminDao;
import com.server.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Admin addAdmin(Admin adminObj) {
		// TODO Auto-generated method stub
		Admin admin=dao.save(adminObj);
		return admin;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteAdminById(int id) {
		// TODO Auto-generated method stub
		boolean flag=dao.existsById(id);
		if(flag==true) {
			dao.deleteById(id);
			flag=true;
		}
		return flag;
	
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)

	public Admin updateAdmin(int id, String adminName) {
		// TODO Auto-generated method stub
		Admin admin=null;
		//validating id
		boolean flag=dao.existsById(id);
		if(flag==true) {
			Optional<Admin> optional=dao.findById(id);
			admin=optional.get();
			admin.setAdminName(adminName);
			admin=dao.save(admin);
			return admin;
		}
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.NEVER)

	public Admin readAdminById(int id) {
		// TODO Auto-generated method stub
		Admin admin=null;
		boolean flag=dao.existsById(id);
		if(flag==true) {
			Optional<Admin> optional=dao.findById(id);
			admin=optional.get();
			return admin;
		}
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.NEVER)

	public List<Admin> readAllAdmins() {
		// TODO Auto-generated method stub
		Iterable<Admin> iterable = dao.findAll();
		List<Admin> list = new ArrayList<Admin>();
		iterable.forEach(list::add);
		return list;
	}

}
