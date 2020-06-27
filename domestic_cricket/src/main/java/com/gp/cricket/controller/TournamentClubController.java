package com.gp.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.TournamentClub;
import com.gp.cricket.service.TournamentClubService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class TournamentClubController {

	@Autowired
	TournamentClubService tournamentClubService;

//	@PostMapping("tournamentclub/{clubId}/{tournamentId}")
//	public ResponseEntity<TournamentClub> tournementClubRegister(@PathVariable("clubId") Integer clubId,
//			@PathVariable("tournamentId") Integer tournamentId) {
//		TournamentClub result = tournamentClubService.tournementClubRegister(clubId, tournamentId);
//		if (result != null) {
//			return ResponseEntity.ok(result);
//		}
//		return ResponseEntity.badRequest().build();
//	}

	@GetMapping("tournamentclub/registered/{clubId}")
	public ResponseEntity<List<TournamentClub>> getClubRegisteredTournaments(@PathVariable("clubId") Integer clubId) {
		List<TournamentClub> result = tournamentClubService.getClubRegisteredTournaments(clubId);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
}
