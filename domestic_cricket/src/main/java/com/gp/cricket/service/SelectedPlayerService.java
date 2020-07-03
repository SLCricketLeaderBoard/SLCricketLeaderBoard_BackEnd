package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.SelectedPlayer;
import com.gp.cricket.repository.SelectedPlayerRepository;

@Service
public class SelectedPlayerService {

	
	@Autowired
	private SelectedPlayerRepository selectedPlayerRepository;
	
	
	public SelectedPlayer saveSelectedPlayer(SelectedPlayer player) {
		return selectedPlayerRepository.save(player);
	}
	
	
	
}
