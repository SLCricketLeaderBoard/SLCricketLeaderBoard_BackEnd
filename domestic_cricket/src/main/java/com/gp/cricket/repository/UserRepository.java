package com.gp.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.cricket.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findUserByEmail(String email);
	
	public User findUserByUserName(String userName);
	
	public User findUserByNic(String nic);
}
