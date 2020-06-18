package com.gp.cricket.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("tournamentRegister")
    public Tournament  registerTournament(@RequestBody Tournament tournament) {
        System.out.println(tournament);
        return tournamentService.registerTournament(tournament);
    }

    @GetMapping("/tournaments")
    public List<Tournament> getAlltournament() {
        return this.tournamentService.getTournaments();
    }

}
