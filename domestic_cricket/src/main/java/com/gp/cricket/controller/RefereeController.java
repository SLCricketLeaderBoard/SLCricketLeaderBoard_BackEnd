package com.gp.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.Referee;
import com.gp.cricket.entity.User;
import com.gp.cricket.service.RefereeService;
import com.gp.cricket.service.UserService;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge=3600)
public class RefereeController {
	
	@Autowired
	RefereeService refereeService;
	
	@Autowired
	UserService userService;
		
	 @PostMapping("/refereeRegister")
	 public Referee saveStudent(@RequestBody User user) {
		 System.out.println(user);
		 return refereeService.saveReferee(user);
	 }
	 
	 @GetMapping("/referees")
	 public List<Referee> getAllReferees(){
		 return this.refereeService.getAllReferees();
	 }
	 

	 @GetMapping("/referee/available")
	 public List<Referee> getAvailableReferees(){
		 return refereeService.getAvailableReferees();
	 }
	 
	 
	 


}
