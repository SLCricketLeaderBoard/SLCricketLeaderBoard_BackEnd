package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gp.cricket.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findUserByEmail(String email);
	
	public User findUserByUserName(String userName);
	
	public User findUserByNic(String nic);
	
	@Query(value="select * from user where status=1",nativeQuery=true)
	List<User> getActiveUsers();
}
