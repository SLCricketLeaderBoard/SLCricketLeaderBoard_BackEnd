package com.gp.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
