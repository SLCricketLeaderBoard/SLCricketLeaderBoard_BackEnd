package com.gp.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.service.TournamentClubPlayerService;
import com.gp.cricket.wrapper.PlayerWrapper;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class TournamentClubPlayerController {

	@Autowired
	TournamentClubPlayerService tournamentClubPlayerService;

	@PostMapping("tournamentclubplayer/{clubId}/{tournamentId}")
	public ResponseEntity<Void> tournamentClubPlayerRegister(@RequestBody PlayerWrapper playerWrapper,
			@PathVariable("clubId") Integer clubId, @PathVariable("tournamentId") Integer tournamentId) {
		Integer result = tournamentClubPlayerService.tournamentClubPlayerRegister(playerWrapper, clubId, tournamentId);
		if (result != null) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}

}
