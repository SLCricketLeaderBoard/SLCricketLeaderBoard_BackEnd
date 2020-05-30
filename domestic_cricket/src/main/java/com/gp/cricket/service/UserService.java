package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gp.cricket.config.security.JwtInMemoryUserDetailsService;
import com.gp.cricket.entity.User;
import com.gp.cricket.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtInMemoryUserDetailsService jwtUser;

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
	
	
	public User getUserByUserId(String userId) {
		Integer x = Integer.parseInt(userId);
		return this.userRepository.findById(x).get();
	}
	
	public User registerUser(User user) {
		
		if(!(isEmailHas(user.getEmail())||isNicHas(user.getNic()))) {
			
			//password encryption object   
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			//update password encrypted
			user.setPassword(encoder.encode(user.getPassword()));
			
			//set user status to 1
			Byte x = 1;
			user.setStatus(x);

			//save user on the database
			user = this.userRepository.save(user);
			
			//add user in the in memory
			jwtUser.addNewUserInMemory(user);
			
			return user;
		}
		return null;
	}
	
	public User resetPassword(User user) {
		
		// remove the users in current jwt memory
		User userTemp = this.getUser(user.getEmail());
		
		jwtUser.removeNewUserInMemory(userTemp);		
		
		
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		//encrypt the password here
//		user.setPassword(encoder.encode(user.getPassword()));
//		
//		//set User status to 1			
//		Byte x = 1;
//		user.setStatus(x);
//		
//		//Update the record
//		user = this.userRepository.save(user);
//		jwtUser.addNewUserInMemory(user);
		return user;
	}
}

	
	
	