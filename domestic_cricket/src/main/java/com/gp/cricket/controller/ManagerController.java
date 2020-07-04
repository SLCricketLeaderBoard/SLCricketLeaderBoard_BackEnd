package com.gp.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.Club;
import com.gp.cricket.entity.Manager;
import com.gp.cricket.entity.User;
import com.gp.cricket.service.ManagerService;
import com.gp.cricket.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class ManagerController {

	@Autowired
	ManagerService managerService;

	@Autowired
	UserService userService;

	@PostMapping("/managerRegister")
	public User saveStudent(@RequestBody User user) {
		System.out.println(user);
		return managerService.saveManager(user).getUserId();
		// registerung managers
	}

	@GetMapping("/managers")
	public List<Manager> getAllManagers() {
		return this.managerService.getAllManagers();
	}

	@GetMapping("/manager/available")
	public List<Manager> getAvailableManagers() {
		return managerService.getAvailableManagers();
	}
	
	@GetMapping("manager/{userId}")
	public ResponseEntity<Manager> getManager(@PathVariable("userId")Integer userId) {
		Manager result = managerService.getManager(userId);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/manager/registrationAccepted")
	public List<Manager> getAcceptedManagers() {
		return managerService.getAcceptedManagers();
	}
	
	@GetMapping("/manager/registrationRequested")
	public List<Manager> getRequestedManagers() {
		return managerService.getRequestedManagers();
	}
	
	@GetMapping("/manager/club/{managerId}")
	public Club getManagerClub(@PathVariable("managerId")Integer managerId) {
		return managerService.getManagerClub(managerId);
	}
	
	

}
