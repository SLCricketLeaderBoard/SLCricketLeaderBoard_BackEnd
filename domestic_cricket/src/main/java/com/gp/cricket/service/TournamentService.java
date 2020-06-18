package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Tournament;
import com.gp.cricket.repository.TournamentRepository;

@Service
public class TournamentService {

    @Autowired
    TournamentRepository tournamentService;

    public Tournament registerTournament(Tournament tournament) {
    	
        return this.tournamentService.save(tournament);
    }

    public List<Tournament> getTournaments() {
        System.out.println("Get all Tournament here");
        
        return this.tournamentService.findAll();
    }
}
