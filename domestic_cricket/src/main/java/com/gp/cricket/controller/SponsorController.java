package com.gp.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.Sponsor;
import com.gp.cricket.service.SponsorService;
import com.gp.cricket.service.UserService;



@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge=3600)

public class SponsorController {

	@Autowired
	SponsorService sponsorService;
	
	@Autowired
	UserService userService;
	
	 @GetMapping("/nonregsponsors")
	 public List<Sponsor> getNonregsponsors(){
		 return this.sponsorService.getNonregsponsors();
	 }
}