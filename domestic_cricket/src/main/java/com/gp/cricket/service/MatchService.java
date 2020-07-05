package com.gp.cricket.service;


import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gp.cricket.entity.Match;
import com.gp.cricket.entity.MatchType;
import com.gp.cricket.entity.Player;
import com.gp.cricket.entity.SelectedPlayer;
import com.gp.cricket.repository.ClubRepository;
import com.gp.cricket.repository.MatchRepository;
import com.gp.cricket.repository.MatchTypeRepository;
import com.gp.cricket.repository.RefereeRepository;
import com.gp.cricket.repository.SelectedPlayerRepository;
import com.gp.cricket.repository.StadiumRepository;
import com.gp.cricket.repository.TournamentClubPlayerRepository;
import com.gp.cricket.repository.TournamentClubRepository;
import com.gp.cricket.repository.TournamentRepository;

@Service
public class MatchService {

	@Autowired
	MatchTypeRepository mathcTypeRepository;

	@Autowired
	MatchRepository matchRepo;
	
	@Autowired
	StadiumRepository stadiumRepository;
	
	@Autowired
	RefereeRepository refereeRepository;
	
	@Autowired
	MatchTypeRepository matchTypeRepository;
	
	@Autowired
	TournamentRepository tournamentRepository;
	
	@Autowired
	TournamentClubRepository tournamnetClubRepository;
	
	@Autowired
	TournamentClubPlayerRepository tournamnetClubPlayerRepository;
	
	@Autowired
	SelectedPlayerRepository selectedPlayerRepository;
	
	@Autowired
	SelectedPlayerService selectedPlayerService;
	
	@Autowired
	ClubRepository clubRepository;

	// For geting match type test t20 odi
	public List<MatchType> getMathcTypes() {
		return mathcTypeRepository.findAll();
	}

	// for saving the data of match
	public Match createMatch(Match match) {	
		
		Match createdMatch = matchRepo.save(match);
		
		Integer tournamentClubIdforclub1 = tournamnetClubRepository.findIdByTournamentAndClub(match.getTournamentIdValue(),match.getClubOneId());
		Integer tournamentClubIdforclub12 = tournamnetClubRepository.findIdByTournamentAndClub(match.getTournamentIdValue(),match.getClubTwoId());
		
		List<Player> club1Players=tournamnetClubPlayerRepository.findPlayersForMatch(tournamentClubIdforclub1);
		List<Player> club2Players=tournamnetClubPlayerRepository.findPlayersForMatch(tournamentClubIdforclub12);
		
		club1Players.forEach((p)->{
			SelectedPlayer record = new SelectedPlayer(null,createdMatch,p);
			selectedPlayerService.saveSelectedPlayer(record);
		});
		
		club2Players.forEach((p)->{
			SelectedPlayer record = new SelectedPlayer(null,createdMatch,p);
			selectedPlayerService.saveSelectedPlayer(record);
		});
		
		return createdMatch;
	}


	public List<Match> findMatchesByTournamentId(Integer tournamentId) {
		// TODO Auto-generated method stub
		return matchRepo.findMatchesByTournamentId(tournamentId);	
	}
	
	// this is for getting a match by match Id (u)
	public Match findMatchById(Integer matchId) {
		return this.matchRepo.findMatchById(matchId);
	}
	
	
	public List<Player> selectedPlayers(Integer matchId,Integer clubId){
		return selectedPlayerRepository.selectedPlayersForMatch(matchId,clubId);
	}
	
	public List<Match> playedMatches(Integer tournamentId){
		LocalDate currentDate = LocalDate.now();
        return matchRepo.getPlayedMatches(currentDate,tournamentId);
	}
	
	public List<Match> toPlayMatches(Integer tournamentId){
		LocalDate currentDate = LocalDate.now();
        return matchRepo.getToPlayMatches(currentDate,tournamentId);
	}
	
	
	public List<Match> getPlayedMatchList(Integer clubId){
		if(clubId!=null && clubRepository.existsById(clubId)) {
			return matchRepo.findByClubId(clubId);
		}
		return null;
	}

	public List<Match> refereeMatchesUpcomming(Integer tournamentId,Integer refreeId){
		
		
		LocalDate currentDate = LocalDate.now();
        return matchRepo.getRefereeMatchesUpcomming(currentDate,tournamentId,refreeId);
	}
	
	public List<Match> refereeMatchesPlayed(Integer tournamentId,Integer refreeId){
		
		LocalDate currentDate = LocalDate.now();
        return matchRepo.getRefereeMatchesPlayed(currentDate,tournamentId,refreeId);
	}
	
	public List<Match> refereeMatchesPlayedUpdated(Integer tournamentId,Integer refereeId){
		
		LocalDate currentDate = LocalDate.now();
        return matchRepo.getRefereeMatchesPlayedUpdated(currentDate, tournamentId, refereeId);
	}
	
	

	
}
