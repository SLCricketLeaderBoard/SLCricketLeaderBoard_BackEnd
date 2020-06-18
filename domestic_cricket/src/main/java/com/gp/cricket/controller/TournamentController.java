package com.gp.cricket.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.gp.cricket.entity.Tournament;
import com.gp.cricket.service.TournamentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @PostMapping("registerTournament")
    public Tournament  registerTournament(@RequestBody Tournament tournament) {
        System.out.println(tournament);
        return tournamentService.registerTournament(tournament);
    }

    @GetMapping("/tournaments")
    public List<Tournament> getAlltournament() {
        return this.tournamentService.getTournaments();
    }
    
	@GetMapping("/tournament/{tournamentId}")
	public ResponseEntity<Tournament> getTournament(@PathVariable Integer tournamentId){
		Optional<Tournament> object = tournamentService.getTournamentById(tournamentId);
		if(object!=null) {
			if(object.isPresent()) {
				return ResponseEntity.ok(object.get());
			}else {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.badRequest().build();
	}
    

}
