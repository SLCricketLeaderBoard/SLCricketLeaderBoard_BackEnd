package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Club;
import com.gp.cricket.entity.Match;
import com.gp.cricket.repository.ClubRepository;


@Service
public class ClubRankingService {
	
	@Autowired
	ClubRepository clubRepository;
	
	Club strongerTeam = new Club();
	Club weakTeam = new Club();
	
	public void clubRanking(Match match) {
		if(match!=null && clubRepository.existsById(match.getClubOneId()) && clubRepository.existsById(match.getClubTwoId())) {
			categoryTeam(match);
			if(match.getMatchTypeId().getMatchTypeId()==1) {// ODI Match
				odiMatchRanking(match);
			}
		}
	}
	
	private void odiMatchRanking(Match match) {
		Double strongerTeamInitialRating = strongerTeam.getRating();
		Double weakTeamInitialRating = weakTeam.getRating();
		
		Double ratingDifference = strongerTeamInitialRating - weakTeamInitialRating;
		if(ratingDifference>=40) {
			
		}else {
			
		}
	}
	
	private void categoryTeam(Match match) {
		Club tem1 = clubRepository.findClubByClubId(match.getClubOneId());
		Club tem2 = clubRepository.findClubByClubId(match.getClubTwoId());
		
//		if(tem1.getRating()>)
	}
}
