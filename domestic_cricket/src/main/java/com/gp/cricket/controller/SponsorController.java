package com.gp.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.Sponsor;
import com.gp.cricket.entity.SponsorClub;
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
	 
	 @GetMapping("/regsponsors")
	 public List<Sponsor> getregsponsors(){
		 return this.sponsorService.getregsponsors();
	 }
	 
	 @PutMapping("sponsorAccept/{userId}")
		public ResponseEntity<Integer> sponsorAccept(@PathVariable("userId") Integer userId){
			Integer result = sponsorService.sponsorAccept(userId);
			if(result!=null) {
				return ResponseEntity.ok(result);
			}
			return ResponseEntity.badRequest().build();
		}
	 
	 @PostMapping("/sponsorclubrequest/{userId}/{clubId}")
		public Boolean sponsorClubRequest(@PathVariable("userId") String userId, @PathVariable("clubId") String clubId) {
		 	System.out.println("============="+userId+"  "+clubId);
			return sponsorService.sponsorClubRequest(Integer.parseInt(userId),Integer.parseInt(clubId));

		}
	 
	/* @GetMapping("/getclubsponsor/{userId}")
	 public List<Sponsor> getclubsponsor(@PathVariable("userId") Integer userId){
		 System.out.println(userId);
		 
		 return sponsorService.getclubsponsor(userId);
	 }*/
}
