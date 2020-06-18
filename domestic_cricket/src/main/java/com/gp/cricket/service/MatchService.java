package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Match;
import com.gp.cricket.entity.MatchType;
import com.gp.cricket.repository.MatchRepository;
import com.gp.cricket.repository.MatchTypeRepository;

@Service
public class MatchService {
	
	@Autowired
	MatchTypeRepository mathcTypeRepository;
	
	@Autowired
	MatchRepository matchRepo;
	
	
	//For geting match type test t20 odi
	public List<MatchType> getMathcTypes(){
		return mathcTypeRepository.findAll();
	}
	
	
	//for saving the data of match 
	public Match createMatch(Match match) {
		return matchRepo.save(match);
	}
	
//	public List<Match> getMathchesByTournamentId(Integer tournamentId){
////		return matchRepo.
//	}
}
