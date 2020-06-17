package com.gp.cricket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Match;
import com.gp.cricket.entity.Tournament;
import com.gp.cricket.repository.TournamentRepository;

@Service
public class TournamentService {

    @Autowired
    TournamentRepository stadiumRepository;

    public Stadium registerStadium(Tournament tournament) {
        return this.tournamentRepository.save(tournament);
    }

    public List<Tournament> getTournament() {
        System.out.println("Get all Tournament here");
        return this.TournamentRepository.findAll();
    }
}
