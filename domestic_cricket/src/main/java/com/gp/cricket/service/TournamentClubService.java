package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.TournamentClub;
import com.gp.cricket.repository.ClubRepository;
import com.gp.cricket.repository.TournamentClubRepository;
import com.gp.cricket.repository.TournamentRepository;

@Service
public class TournamentClubService {

	@Autowired
	TournamentClubRepository tournamentClubRepository;

	@Autowired
	TournamentRepository tournamentRepository;

	@Autowired
	ClubRepository clubRepository;

	public TournamentClub tournementClubRegister(Integer clubId, Integer tournamentId) {
		if (clubId != null && tournamentId != null) {
			if (clubRepository.existsById(clubId) && tournamentRepository.existsById(tournamentId)) {
				TournamentClub tournamentClub = new TournamentClub(0, (byte) 1, clubRepository.findClubByClubId(clubId),
						tournamentRepository.findClubByTournamentId(tournamentId));
				return tournamentClubRepository.save(tournamentClub);
			}
		}
		return null;
	}

	private Boolean tournementClubObjectValidated(TournamentClub object) {
		if (object.getClubId() != null && object.getTournamentId() != null && object.getStatus() != null) {
			return true;
		}
		return false;
	}

	public List<TournamentClub> getClubRegisteredTournaments(Integer clubId) {
		if(clubId!=null && clubRepository.existsById(clubId)) {
			return tournamentClubRepository.findByclubId(clubRepository.findClubByClubId(clubId));
		}
		return null;
	}

}
