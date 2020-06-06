package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.repository.MatchTypeRepository;

@Service
public class MatchTypeService {
	
	@Autowired
	MatchTypeRepository repository;
	
	
}
