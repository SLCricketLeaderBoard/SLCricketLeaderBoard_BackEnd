package com.gp.cricket.controller;

import java.math.MathContext;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.Manager;
import com.gp.cricket.entity.MatchType;
import com.gp.cricket.service.MatchService;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge=3600)
public class MatchController {

	@Autowired
	MatchService matchService;
	
	// get match types test odi T20 
	 @GetMapping("/matchType")
	 public List<MatchType> getAllManagers(){
		 return matchService.getMathcTypes();
	 }
}
