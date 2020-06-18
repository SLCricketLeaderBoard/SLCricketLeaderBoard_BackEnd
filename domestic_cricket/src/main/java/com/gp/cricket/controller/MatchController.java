package com.gp.cricket.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.gp.cricket.entity.Match;
import com.gp.cricket.entity.MatchType;
import com.gp.cricket.service.MatchService;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge=3600)
public class MatchController {

	@Autowired
	MatchService matchService;
	
	// get match types test odi T20 
	 @GetMapping("/matchType")
	 public List<MatchType> getMatchTypes(){
		 return matchService.getMathcTypes();
	 }
	 
	 @PostMapping("/createMatch")
	 public Match createMathc(@RequestBody Match match) {
		 System.out.println(match);
		 return matchService.createMatch(match);
		//  registerung managers
	 }
	 
//	 @GetMapping("/matches/{tournamentId}")
//	 public List<MatchType> getAllManagers(@PathVariable("tournamentId")Integer tournamentId){
//		 return matchService.getMathchesByTournamentId(tournamentId);
//	 }
	 
}
