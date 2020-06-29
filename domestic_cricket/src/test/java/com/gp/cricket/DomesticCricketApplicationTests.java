package com.gp.cricket;


import java.math.MathContext;
import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gp.cricket.controller.MatchController;
import com.gp.cricket.entity.Match;
import com.gp.cricket.entity.MatchType;
import com.gp.cricket.entity.Referee;
import com.gp.cricket.entity.Stadium;
import com.gp.cricket.entity.Tournament;
import com.gp.cricket.repository.MatchRepository;
import com.gp.cricket.repository.MatchTypeRepository;
import com.gp.cricket.repository.RefereeRepository;
import com.gp.cricket.repository.StadiumRepository;
import com.gp.cricket.repository.TournamentRepository;
import com.gp.cricket.service.TournamentClubService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=DomesticCricketApplication.class)
class DomesticCricketApplicationTests {

//	@Autowired
//	MatchTypeRepository matchType;
//	
//	@Autowired
//	TournamentRepository tourRepo;
//	
//	@Autowired
//	StadiumRepository stdRepo;
//	
//	@Autowired
//	RefereeRepository refrepo;
//	
//	@Autowired
//	MatchRepository matchRepo;
//	
//	
//	private Integer matchId = null;
//	private Integer club1Id = 2;
//	private Integer club2Id = 3;
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
//	
//	
//	@Test
//	void saveMathc() {
//		matchTypeId = matchType.findById(1).get() ;
//		tournamentId = tourRepo.findById(1).get() ;
//		stadiumId = stdRepo.findById(1).get();
//		refereeId = refrepo.findById(1).get();
//		startdate = LocalDate.now();
//		finishDate = LocalDate.now();
//		Match x = new Match(matchId,club1Id,club2Id,captainClub1,captainClub2,club1Mark,club2Mark,club1Wicket,club2Wicket,tournementRound,startdate,finishDate,startTime,winTeamId,sponsor,matchTypeId,tournamentId,stadiumId,refereeId,umpire1Id,umpire2Id,umpire3Id,tossWinTeam);
//		x.toString();
//		Match result = matchRepo.save(x);
////		System.out.println(result);
//	}
	
	
	
	// @Autowired
	// TournamentClubService x;
	
	// @Test
	// void getClubsformatches(){
	
	// 	x.getClubsRegisteredTournament(1);
		
	// }
	
}
