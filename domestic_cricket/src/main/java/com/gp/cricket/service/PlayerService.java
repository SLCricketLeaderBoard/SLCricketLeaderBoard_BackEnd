package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Player;
import com.gp.cricket.entity.User;
import com.gp.cricket.repository.ClubRepository;
import com.gp.cricket.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	ClubRepository clubRepository;

	@Autowired
	UserService userService;

	public Integer playerRegister(Player player) {
		if (validPlayerObject(player)) {
			User user = userService.registerUser(player.getUserId());
			if (user != null) {
				player.setUserId(user);
				playerRepository.save(player);
				return 1;
			}
			return 0;
		}
		return null;
	}

	public Boolean validPlayerObject(Player player) {
		if (player.getUserId() != null && player.getSpecialType() != null && player.getBatmanTypeId() != null
				&& player.getBallerTypeId() != null && player.getClubId() != null) {
			return true;
		}
		return false;
	}
	
	public List<Player> getClubPlayerList(Integer clubId){
		if(clubId!=null && clubId>0) {
			return playerRepository.findPlayerByClubId(clubRepository.findClubByClubId(clubId));
		}
		return null;
	}
}
