package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Player;
import com.gp.cricket.entity.TournamentClub;
import com.gp.cricket.entity.TournamentClubPlayer;
import com.gp.cricket.repository.TournamentClubPlayerRepository;
import com.gp.cricket.wrapper.PlayerWrapper;

@Service
public class TournamentClubPlayerService {

	@Autowired
	TournamentClubService tournamentClubService;

	@Autowired
	TournamentClubPlayerRepository tournamentClubPlayerRepository;

	public Integer tournamentClubPlayerRegister(PlayerWrapper playerWrapper, Integer clubId, Integer tournamentId) {

		if (clubId != null && tournamentId != null && playerWrapper != null) {
			TournamentClub tournamentClub = tournamentClubService.tournementClubRegister(clubId, tournamentId);
			if (tournamentClub != null) {
				for (Player player : playerWrapper.getPlayerList()) {
					TournamentClubPlayer tournamentClubPlayer = new TournamentClubPlayer(0, tournamentClub, player);
					tournamentClubPlayerRepository.save(tournamentClubPlayer);
				}
				return 1;
			}
		}
		return null;
	}
}
