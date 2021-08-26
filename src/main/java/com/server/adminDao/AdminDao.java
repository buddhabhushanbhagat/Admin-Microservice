package com.server.adminDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.server.model.Admin;

@Repository
public interface AdminDao extends CrudRepository<Admin, Integer> {

}
