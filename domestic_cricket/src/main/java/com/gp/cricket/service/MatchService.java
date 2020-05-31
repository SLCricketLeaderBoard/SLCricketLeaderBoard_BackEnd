package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gp.cricket.entity.Match;
import com.gp.cricket.repository.MatchRepository;

public class MatchService {
	
	@Autowired
	MatchRepository matchRepo;

	public Match getMatch(Integer id) {
		return matchRepo.findById(id).get();
	}
	
}
