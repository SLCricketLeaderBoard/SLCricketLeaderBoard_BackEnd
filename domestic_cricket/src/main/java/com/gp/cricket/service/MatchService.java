package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Match;
import com.gp.cricket.entity.MatchType;
import com.gp.cricket.entity.Referee;
import com.gp.cricket.entity.Stadium;
import com.gp.cricket.entity.Tournament;
import com.gp.cricket.repository.MatchRepository;
import com.gp.cricket.repository.MatchTypeRepository;
import com.gp.cricket.repository.RefereeRepository;
import com.gp.cricket.repository.StadiumRepository;
import com.gp.cricket.repository.TournamentRepository;

@Service
public class MatchService {

	@Autowired
	MatchTypeRepository mathcTypeRepository;

	@Autowired
	MatchRepository matchRepo;
	
	@Autowired
	StadiumRepository stadiumRepository;
	
	@Autowired
	RefereeRepository refereeRepository;
	
	@Autowired
	MatchTypeRepository matchTypeRepository;
	
	@Autowired
	TournamentRepository tournamentRepository;

	// For geting match type test t20 odi
	public List<MatchType> getMathcTypes() {
		return mathcTypeRepository.findAll();
	}

	// for saving the data of match
	public Match createMatch(Match match) {		
		return matchRepo.save(match);
	}


	public List<Match> findMatchesByTournamentId(Integer tournamentId) {
		// TODO Auto-generated method stub
		return matchRepo.findMatchesByTournamentId(tournamentId);	
	}
	
}
