package com.gp.cricket;


import java.math.MathContext;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gp.cricket.controller.MatchController;
import com.gp.cricket.entity.Match;
import com.gp.cricket.entity.MatchType;
import com.gp.cricket.entity.Player;
import com.gp.cricket.entity.Referee;
import com.gp.cricket.entity.Stadium;
import com.gp.cricket.entity.Tournament;
import com.gp.cricket.repository.MatchRepository;
import com.gp.cricket.repository.MatchTypeRepository;
import com.gp.cricket.repository.RefereeRepository;
import com.gp.cricket.repository.StadiumRepository;
import com.gp.cricket.repository.TournamentClubPlayerRepository;
import com.gp.cricket.repository.TournamentClubRepository;
import com.gp.cricket.repository.TournamentRepository;
import com.gp.cricket.service.MatchService;
import com.gp.cricket.service.TournamentClubService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=DomesticCricketApplication.class)
class DomesticCricketApplicationTests {

	@Autowired
	MatchTypeRepository matchType;
	
	@Autowired
	TournamentRepository tourRepo;
	
	@Autowired
	StadiumRepository stdRepo;
	
	@Autowired
	RefereeRepository refrepo;
	
	@Autowired
	MatchRepository matchRepo;
	
	@Autowired
	MatchService matchService;
	
//	private Integer matchId = null;
//	private Integer club1Id = 2;
//	private Integer club2Id = 2;
//	private Integer captainClub1= 2;
//	private Integer captainClub2= 3;
//	private Integer club1Mark= 1;
//	private Integer club2Mark= 1;
//	private Integer club1Wicket= 1; 
//	private Integer club2Wicket= 1;
//	private Integer tournementRound= 1;
//	private LocalDate startdate;
//	private LocalDate finishDate;
//	private String startTime ="ajsb";
//	private Integer winTeamId = 1;
//	private String sponsor= "asasdsd";
//	private MatchType matchTypeId ;
//	private Tournament tournamentId ;
//	private Stadium stadiumId ;
//	private Referee refereeId;
//	private Integer umpire1Id = 1;
//	private Integer umpire2Id = 2;
//	private Integer umpire3Id = 3;
//	private Integer tossWinTeam = 1;
//	private Integer clubOneViceCaptain = 1;
//	private Integer clubTwoViceCaptain= 1;
//	private Integer clubOneKeper= 1;
//	private Integer clubTwoKeper= 1;
//	private Integer manOfTheMatch= 1;
	
//	@Test
//	void saveMathc() {
//		matchTypeId = matchType.findById(1).get() ;
//		tournamentId = tourRepo.findById(1).get() ;
//		stadiumId = stdRepo.findById(1).get();
//		refereeId = refrepo.findById(1).get();
//		startdate = LocalDate.now();
//		finishDate = LocalDate.now();
//		Match x = new Match(matchId,club1Id,club2Id,captainClub1,captainClub2,club1Mark,club2Mark,club1Wicket,club2Wicket,tournementRound,startdate,finishDate,startTime,winTeamId,sponsor,matchTypeId,tournamentId,stadiumId,refereeId,umpire1Id,umpire2Id,umpire3Id,tossWinTeam,clubOneViceCaptain,clubTwoViceCaptain,clubOneKeper,clubTwoKeper,manOfTheMatch);
//		x.toString();
//		
//		matchService.createMatch(x);
//		
////		Match result = matchRepo.save(x);
////		System.out.println(result);
//	}
	
	
	
//	 @Autowired
//	 TournamentClubService x2;
//	 
//	
//	 @Autowired
//	 TournamentClubRepository x;
//	 
//	 @Autowired
//	 TournamentClubPlayerRepository tournamnetClubPlayerRepository;
//	 
//	 
//	 
//	 
//	 @Test
//	 void getClubsformatches(){
//	
////	 Integer tournamnetClubId = x.findIdByTournamentAndClub(1, 2);
////	 System.out.println(tournamnetClubId);
////	 List<Player> players = tournamnetClubPlayerRepository.findPlayersForMatch(tournamnetClubId);
////	 
////	 players.forEach((p)->{System.out.println(p.getPlayerId());});
//////	 	System.out.println(x);
//		
//	 }
	
	@Test
	public void selectedPlayers() {
//		matchService.selectedPlayers(53,2);
//		matchService.playedMatches(1);
//		matchService.refereeMatchesPlayed(1,"26");
//		matchService.refereeMatchesUpcomming(1,"26");
		
		
	}
	
}
