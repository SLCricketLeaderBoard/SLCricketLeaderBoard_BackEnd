package com.gp.cricket.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();		
	}
	
	@PutMapping("club")
	public ResponseEntity<Integer> clubUpdate(@Valid @RequestBody Club club){
		Integer result = clubService.clubUpdate(club);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("club/list/{status}")
	public List<Club> getClubs(@PathVariable Byte status){
		return clubService.getClubs(status);
	}
	
	@GetMapping("club/{clubId}")
	public ResponseEntity<Club> getClubData(@NotNull @Min(1) @PathVariable Integer clubId){
		Optional<Club> object = clubService.getClubData(clubId);
		if(object!=null) {
			if(object.isPresent()) {
				return ResponseEntity.ok(object.get());
			}else {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("club/manager/{userId}")
	public ResponseEntity<Club> getClubDataOfManager(@NotNull @Min(1) @PathVariable Integer userId){
		Club object = clubService.getClubDataOfManager(userId);
		if(object!=null) {
			return ResponseEntity.ok(object);
		}
		return ResponseEntity.badRequest().build();
	}
}
