package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gp.cricket.entity.Manager;


public interface ManagerRepository extends JpaRepository<Manager, Integer>{
	
	@Query("FROM Manager m WHERE  m.userId.status = 1  AND (m.managerId NOT IN (SELECT c.managerId FROM Club c))")
	public List<Manager> getAvailableManagers();

}
