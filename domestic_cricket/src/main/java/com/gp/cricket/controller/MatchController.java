package com.gp.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.Match;
import com.gp.cricket.service.MatchService;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge=3600)
public class MatchController {

	@Autowired
	MatchService service;
	
	public Match getMatch(Integer id) {
		
		return service.getMatch(id);
	}
}
