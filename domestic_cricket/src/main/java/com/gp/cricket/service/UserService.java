package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.User;
import com.gp.cricket.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User userRegister(User user) {

		return null;
	}

		
	public User getUser(String email) {		
		return userRepository.findByEmail(email);
	}

	
	
	public Boolean isEmailHas(String email) {
		User user = userRepository.findUserByEmail(email);
		if (user != null && email.equals(user.getEmail())) {
			return true;
		}
		return false;
	}

	public Boolean isUserNameHas(String userName) {
		User user = userRepository.findUserByUserName(userName);
		if (user != null && userName.equals(user.getUserName())) {
			return true;
		}
		return false;
	}

	public Boolean isNicHas(String nic) {
		User user = userRepository.findUserByNic(nic);
		if (user != null && nic.equals(user.getNic())) {
			return true;
		}
		return false;
	}
	
	public User saveUser(User user) {
		return this.userRepository.save(user);
	}
}
