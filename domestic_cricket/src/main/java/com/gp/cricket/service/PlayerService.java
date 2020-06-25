package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Player;
import com.gp.cricket.entity.User;
import com.gp.cricket.repository.ClubRepository;
import com.gp.cricket.repository.PlayerRepository;
import com.gp.cricket.repository.UserRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	ClubRepository clubRepository;

	@Autowired
	UserService userService;

	public Integer playerSignup(Player player) {
		if (validPlayerObject(player)) {
			User user = userService.signupUser(player.getUserId());
			if (user != null) {
				player.setUserId(user);
				playerRepository.save(player);
				return 1;
			}
			return 0;
		}
		return null;
	}

	public Integer playerUpdate(Player player) {
		if (validPlayerObject(player)) {
			Integer userUpdateResult = userService.updateUser(player.getUserId());
			if(userUpdateResult==1) {
				playerRepository.save(player);
			}
			return userUpdateResult;
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

	public List<Player> getClubPlayerList(Integer clubId, Byte status) {
		if (clubId != null && clubId > 0 && status >= 0 && status <= 1) {
			return playerRepository.findPlayerByClubId(clubRepository.findClubByClubId(clubId), status);
		}
		return null;
	}

	public Player getPlayer(Integer playerId) {
		if (playerId != null && playerId > 0) {
			return playerRepository.findPlayerById(playerId);
		}
		return null;
	}
}
