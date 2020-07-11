package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Club;
import com.gp.cricket.entity.Player;
import com.gp.cricket.entity.Tournament;
import com.gp.cricket.entity.TournamentClub;
import com.gp.cricket.entity.TournamentClubPlayer;
import com.gp.cricket.repository.ClubRepository;
import com.gp.cricket.repository.TournamentClubPlayerRepository;
import com.gp.cricket.repository.TournamentClubRepository;
import com.gp.cricket.repository.TournamentRepository;
import com.gp.cricket.wrapper.PlayerWrapper;

@Service
public class TournamentClubPlayerService {

	@Autowired
	TournamentClubService tournamentClubService;

	@Autowired
	TournamentClubPlayerRepository tournamentClubPlayerRepository;

	@Autowired
	TournamentClubRepository tournamentClubRepository;

	@Autowired
	ClubRepository clubRepository;

	@Autowired
	TournamentRepository tournamentRepository;

	public TournamentClub tournamentClubPlayerRegister(PlayerWrapper playerWrapper, Integer clubId, Integer tournamentId) {
		if (clubId != null && tournamentId != null && playerWrapper != null
				&& tournamentRepository.existsById(tournamentId) && clubRepository.existsById(clubId)) {
			Club club = clubRepository.findClubByClubId(clubId);
			Tournament tournament = tournamentRepository.findByTournamentId(tournamentId);
			TournamentClub result = tournamentClubService.tournementClubRegister(club, tournament);
			if (result != null) {
				TournamentClub tournamentClub = tournamentClubRepository.findByClubIdAndTournamentId(club, tournament);
				for (Player player : playerWrapper.getPlayerList()) {
					TournamentClubPlayer tournamentClubPlayer = new TournamentClubPlayer(0, tournamentClub, player);
					tournamentClubPlayerRepository.save(tournamentClubPlayer);
				}
				return result;
			}
			return null;// Already registered
		}
		return null;
	}

	public List<Player> tournamentClubPlayerList(Integer clubId, Integer tournamentId) {
		if (clubId != null && tournamentId != null && tournamentRepository.existsById(tournamentId)
				&& clubRepository.existsById(clubId)) {

			Club club = clubRepository.findClubByClubId(clubId);
			Tournament tournament = tournamentRepository.findByTournamentId(tournamentId);
			TournamentClub tournamentClub = tournamentClubRepository.findByClubIdAndTournamentId(club, tournament);
			if (tournamentClub != null) {
				return tournamentClubPlayerRepository.findByTournamentClubId(tournamentClub);
			}
		}
		return null;
	}

	public TournamentClub tournamentClubPlayerUpdate(PlayerWrapper playerWrapper, Integer clubId, Integer tournamentId) {
		if (clubId != null && tournamentId != null && playerWrapper != null
				&& tournamentRepository.existsById(tournamentId) && clubRepository.existsById(clubId)) {

			Club club = clubRepository.findClubByClubId(clubId);
			Tournament tournament = tournamentRepository.findByTournamentId(tournamentId);
			TournamentClub tournamentClub = tournamentClubRepository.findByClubIdAndTournamentId(club, tournament);

			if (tournamentClub != null) {
				tournamentClubPlayerRepository.deleteByTournamentClubId(tournamentClub);// Delete previous selected
																						// player list
				for (Player player : playerWrapper.getPlayerList()) {// Insert update player list
					TournamentClubPlayer tournamentClubPlayer = new TournamentClubPlayer(0, tournamentClub, player);
					tournamentClubPlayerRepository.save(tournamentClubPlayer);
				}
				return tournamentClub;
			}

		}
		return null;
	}
}
