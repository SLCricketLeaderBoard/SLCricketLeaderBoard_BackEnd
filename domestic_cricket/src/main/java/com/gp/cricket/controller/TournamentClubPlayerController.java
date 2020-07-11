package com.gp.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.Player;
import com.gp.cricket.entity.TournamentClub;
import com.gp.cricket.entity.TournamentClubPlayer;
import com.gp.cricket.service.TournamentClubPlayerService;
import com.gp.cricket.wrapper.PlayerWrapper;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class TournamentClubPlayerController {

	@Autowired
	TournamentClubPlayerService tournamentClubPlayerService;

	@PostMapping("tournamentclubplayer/{clubId}/{tournamentId}")
	public ResponseEntity<TournamentClub> tournamentClubPlayerRegister(@RequestBody PlayerWrapper playerWrapper,
			@PathVariable("clubId") Integer clubId, @PathVariable("tournamentId") Integer tournamentId) {
		TournamentClub result = tournamentClubPlayerService.tournamentClubPlayerRegister(playerWrapper, clubId, tournamentId);
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("tournamentclubplayer/{clubId}/{tournamentId}")
	public ResponseEntity<List<Player>>  tournamentClubPlayerList(@PathVariable("tournamentId")Integer tournamentId,@PathVariable("clubId") Integer clubId){
		List<Player> result = tournamentClubPlayerService.tournamentClubPlayerList(clubId, tournamentId);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("tournamentclubplayer/{clubId}/{tournamentId}")
	public ResponseEntity<TournamentClub> tournamentClubPlayerUpdate(@RequestBody PlayerWrapper playerWrapper,
			@PathVariable("clubId") Integer clubId, @PathVariable("tournamentId") Integer tournamentId) {
		TournamentClub result = tournamentClubPlayerService.tournamentClubPlayerUpdate(playerWrapper, clubId, tournamentId);
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}

}
