package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.config.security.JwtInMemoryUserDetailsService;
import com.gp.cricket.entity.Manager;
import com.gp.cricket.entity.User;
import com.gp.cricket.repository.ManagerRepository;

@Service
public class ManagerService {

<<<<<<< HEAD
	@Autowired
	ManagerRepository managerRepository;

	@Autowired
	UserService userService;

	@Autowired
	JwtInMemoryUserDetailsService jwtUser;

	//		save manager first save user then save manager 
		public Manager saveManager(User user) {
			Byte x =1;
			user.setStatus(x);
			User tempUser=userService.registerUser(user);
			Manager manager = new Manager(null,tempUser);
			return this.managerRepository.save(manager);
		}

	public List<Manager> getAllManagers() {
		System.out.println("Get all managers here");
		return this.managerRepository.findAll();

	}

	public List<Manager> getAvailableManagers() {
		return managerRepository.getAvailableManagers();
	}

}
