package com.gp.cricket.controller;


import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.User;
import com.gp.cricket.service.UserService;


@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge=3600)
public class UserController {
	
	@Autowired
	UserService userService;
	
	public ResponseEntity<User> userRegister(@Validated @RequestBody User user){
		return null;
	}
	
	
	@GetMapping("user/{email}")
	public ResponseEntity<User> getUser(@NotNull @PathVariable("email") String email) {	
		User reply = userService.getUser(email);	
		if(reply != null) {
			return ResponseEntity.ok(reply);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("profile/{userId}")
	public ResponseEntity<User> getUserByUserName(@NotNull @PathVariable("userId") String userId) {	
		User reply = userService.getUserByUserId(userId);	
		if(reply != null) {
			return ResponseEntity.ok(reply);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping("user/resetPassword")
	public String resetPassword(@RequestBody User user){
		try {
			this.userService.resetPassword(user);
			return "Password changing successfull!";
			
		} catch (Exception e) {
			System.out.println(e);
			return "Password reseting failed";
		}
		
	}
	
	@PostMapping("user/updateProfile")
	public String updateProfile(@RequestBody User user){
		try {
			this.userService.updateUserProfile(user);
			return "Updating successfull!";
			
		} catch (Exception e) {
			System.out.println(e);
			return "Updating failed";
		}
		
	}
	
	
}
