package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.MatchType;
import com.gp.cricket.repository.MatchTypeRepository;

@Service
public class MatchService {
	
	@Autowired
	MatchTypeRepository mathcTypeRepository;
	
	
	//For geting match type test t20 odi
	public List<MatchType> getMathcTypes(){
		return mathcTypeRepository.findAll();
	}
	
	
}
