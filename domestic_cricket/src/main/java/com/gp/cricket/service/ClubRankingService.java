package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Club;
import com.gp.cricket.entity.ClubRanking;
import com.gp.cricket.entity.Match;
import com.gp.cricket.entity.MatchType;
import com.gp.cricket.repository.ClubRankingRepository;
import com.gp.cricket.repository.ClubRepository;
import com.gp.cricket.repository.MatchRepository;


@Service
public class ClubRankingService {
	
	@Autowired
	ClubRepository clubRepository;
	
	@Autowired 
	ClubRankingRepository clubRankingRepository;
	
	@Autowired
	MatchRepository matchRepository;
	
	ClubRanking strongerTeam = new ClubRanking();
	ClubRanking weakTeam = new ClubRanking();
	
	public void clubRanking(Match match) {
		if(match!=null && clubRepository.existsById(match.getClubOneId()) && clubRepository.existsById(match.getClubTwoId())) {
			if(checkMatchCountValid(match)) {//Ensure not insert same data twice
				categoryTeam(match);
				Integer matchType = match.getMatchTypeId().getMatchTypeId();
				if(matchType==1 || matchType==2) {// ODI,T20 Match
					odiANDT20MatchRanking(match);
				}else {//Test
					
				}
			}
		}
	}
	
	private void odiANDT20MatchRanking(Match match) {
		Double strongerTeamInitialRating = strongerTeam.getRating();
		Double weakTeamInitialRating = weakTeam.getRating();
		
		Double strongerTeamInitialPoints = strongerTeam.getPoints();
		Double weakTeamInitialPoints = weakTeam.getPoints();
		
		Integer strongerTeamNumMatch = strongerTeam.getNumMatch();
		Integer weakTeamNumMatch = weakTeam.getNumMatch();
		
		Double ratingDifference = strongerTeamInitialRating - weakTeamInitialRating;
		if(ratingDifference>=40) {
			if(strongerTeam.getClubId().getClubId() == match.getWinTeamId()) {//Stronger Team win
				strongerTeam.setPoints(strongerTeamInitialPoints + (strongerTeamInitialRating+10) );
				strongerTeam.setRating(strongerTeam.getPoints()/strongerTeamNumMatch);
				
				weakTeam.setPoints(weakTeamInitialPoints + (weakTeamInitialRating-10) );
				weakTeam.setRating(weakTeam.getPoints()/weakTeamNumMatch);
			}else if(weakTeam.getClubId().getClubId() == match.getWinTeamId()) {//Weak Team win
				strongerTeam.setPoints(strongerTeamInitialPoints + (strongerTeamInitialRating-90) );
				strongerTeam.setRating(strongerTeam.getPoints()/strongerTeamNumMatch);
				
				weakTeam.setPoints(weakTeamInitialPoints + (weakTeamInitialRating+90) );
				weakTeam.setRating(weakTeam.getPoints()/weakTeamNumMatch);
			}else {//Match grow
				strongerTeam.setPoints(strongerTeamInitialPoints + (strongerTeamInitialRating-40) );
				strongerTeam.setRating(strongerTeam.getPoints()/strongerTeamNumMatch);
				
				weakTeam.setPoints(weakTeamInitialPoints + (weakTeamInitialRating+40) );
				weakTeam.setRating(weakTeam.getPoints()/weakTeamNumMatch);
			}
		}else {//ratingDifference<40
			if(strongerTeam.getClubId().getClubId() == match.getWinTeamId()) {//Stronger team win
				strongerTeam.setPoints(strongerTeamInitialPoints + (weakTeamInitialRating+50));
				strongerTeam.setRating(strongerTeam.getPoints()/strongerTeamNumMatch);
				
				weakTeam.setPoints(weakTeamInitialPoints + (strongerTeamInitialRating-50));
				weakTeam.setRating(weakTeam.getPoints()/weakTeamNumMatch);
			}else if(weakTeam.getClubId().getClubId() == match.getWinTeamId()) {//weak team win
				weakTeam.setPoints(weakTeamInitialPoints + (strongerTeamInitialRating+50));
				weakTeam.setRating(weakTeam.getPoints()/weakTeamNumMatch);
				
				strongerTeam.setPoints(strongerTeamInitialPoints + (weakTeamInitialRating-50));
				strongerTeam.setRating(strongerTeam.getPoints()/strongerTeamNumMatch);
			}else {//grow
				strongerTeam.setPoints(strongerTeamInitialPoints + weakTeamInitialRating);
				strongerTeam.setRating(strongerTeam.getPoints()/strongerTeamNumMatch);
				
				weakTeam.setPoints(weakTeamInitialPoints + strongerTeamInitialRating);
				weakTeam.setRating(weakTeam.getPoints()/weakTeamNumMatch);
			}
		}
		
		clubRankingRepository.save(strongerTeam);
		clubRankingRepository.save(weakTeam);
	}
	
	private void categoryTeam(Match match) {
		Integer club1 = match.getClubOneId();
		Integer club2 = match.getClubTwoId();
		MatchType matchType = match.getMatchTypeId();
		
		ClubRanking tem1 = getClubRankingofClub(club1, matchType);
		ClubRanking tem2 = getClubRankingofClub(club2, matchType);
		
		if(tem1.getRating() >= tem2.getRating() ) {
			strongerTeam = tem1;
			weakTeam = tem2;
		}else {
			strongerTeam = tem2;
			weakTeam = tem1;
		}
	}
	
	private ClubRanking getClubRankingofClub(Integer clubId, MatchType matchType) {
		ClubRanking ob = clubRankingRepository.findByClubIdANDMatchType(clubId, matchType.getMatchTypeId());
		
		if(ob!=null) {
			ob.setNumMatch(ob.getNumMatch()+1);
			return ob;
		}
		
		ob = new ClubRanking();
		ob.setClubId(clubRepository.findClubByClubId(clubId));
		ob.setMatchTypeId(matchType);
		ob.setPoints(0D);
		ob.setRating(0D);
		ob.setNumMatch(1);
		return new ClubRanking();
	}
	
	private Boolean checkMatchCountValid(Match match) {//Check only one club is enough
		Integer clubId = match.getClubOneId();
		ClubRanking clubRank = clubRankingRepository.findByClubIdANDMatchType(clubId, match.getMatchTypeId().getMatchTypeId());
		
		if(clubRank != null) {
			Integer clubRankMatchCount = clubRank.getNumMatch();
			Integer matchTableMatchCount = matchRepository.getNumOfMatchPlayed(clubId);
			
			if(clubRankMatchCount < matchTableMatchCount) {
				return true;
			}
		}else {
			return true;
		}
		
		return false;
	}
	
	 
}
