package com.gp.cricket.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Tournament;
import com.gp.cricket.entity.TournamentClub;
import com.gp.cricket.repository.ClubRepository;
import com.gp.cricket.repository.TournamentRepository;

@Service
public class TournamentService {


    @Autowired
    TournamentRepository tournamentRepo;

	@Autowired
	ClubRepository clubRepository;

    public Tournament registerTournament(Tournament tournament) {
    	
        return this.tournamentRepo.save(tournament);
    }
    
    public List<Tournament> getAllTournaments() {
     
        return tournamentRepo.findAll();
    }

    public List<Tournament> getRegistrationClosedTournaments() {
        Date currentDate = new Date();
        return tournamentRepo.closedTournaments(currentDate);
    }
    
    public List<Tournament> getRegistrationOpenedTournaments() {
        Date currentDate = new Date();
        return tournamentRepo.pendingTournaments(currentDate);
    }
    
    public Optional<Tournament> getTournamentById(Integer id) {
    	return this.tournamentRepo.findById(id);
    }

	public List<Tournament> getUpcomingTournamentForClub(Integer clubId) {
		if (clubId != null && clubRepository.existsById(clubId)) {
			return tournamentRepo.findUpcomingTournamentForClubByClubId(clubRepository.findClubByClubId(clubId));
		}
		return null;
	}

	public List<Tournament> getTournamentsByDateOrder() {
		Date currentDate = new Date();
//		 return tournamentRepo.findAll();
		return tournamentRepo.getTournamentByDateOrder(currentDate);
	}
    
	

	public List<Tournament> getTournamentsHistory() {
		Date currentDate = new Date();
//		 return tournamentRepo.findAll();
		return tournamentRepo.getTournamentHistory(currentDate);
	}
    

}
