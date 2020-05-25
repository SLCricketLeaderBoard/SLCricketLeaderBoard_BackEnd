package com.gp.cricket.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.Club;
import com.gp.cricket.service.ClubService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class ClubController {

	@Autowired
	ClubService clubService;

	@PostMapping("club")
	public ResponseEntity<Integer> clubRegister(@Valid @RequestBody Club club) {
		
		Integer result = clubService.clubRegister(club);
		return ResponseEntity.ok(result);
		
	}
}
