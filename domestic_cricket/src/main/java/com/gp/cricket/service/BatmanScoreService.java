package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gp.cricket.entity.BatmanScore;
import com.gp.cricket.repository.BatmanScoreRepository;

public class BatmanScoreService {
	@Autowired
	BatmanScoreRepository batmanScoreRepository;
	
	public BatmanScore saveRecord(BatmanScore batmanScore) {
		return batmanScoreRepository.save(batmanScore);
	}

}
