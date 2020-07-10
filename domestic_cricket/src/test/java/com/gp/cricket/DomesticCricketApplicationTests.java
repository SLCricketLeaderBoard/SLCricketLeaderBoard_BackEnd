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
import com.gp.cricket.entity.BallerRecord;
import com.gp.cricket.entity.BatmanRecord;
import com.gp.cricket.entity.FieldingRecord;
import com.gp.cricket.entity.Match;
import com.gp.cricket.entity.MatchType;
import com.gp.cricket.entity.Player;
import com.gp.cricket.entity.Referee;
import com.gp.cricket.entity.SelectedPlayer;
import com.gp.cricket.entity.Stadium;
import com.gp.cricket.entity.Tournament;
import com.gp.cricket.repository.MatchRepository;
import com.gp.cricket.repository.MatchTypeRepository;
import com.gp.cricket.repository.RefereeRepository;
import com.gp.cricket.repository.SelectedPlayerRepository;
import com.gp.cricket.repository.StadiumRepository;
import com.gp.cricket.repository.TournamentClubPlayerRepository;
import com.gp.cricket.repository.TournamentClubRepository;
import com.gp.cricket.repository.TournamentRepository;
import com.gp.cricket.service.BallerRecordService;
import com.gp.cricket.service.BatmanRecordService;
import com.gp.cricket.service.FieldingRecordService;
import com.gp.cricket.service.MatchService;
import com.gp.cricket.service.SponsorService;
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
	
	@Autowired
	SponsorService sponserservicel;
	
	@Autowired
	SelectedPlayerRepository selectedPlayerRepo;
	
	@Autowired
	BallerRecordService ballerRecordService;
	
	
	@Autowired
	BatmanRecordService batmanRecordService;
	
	@Autowired
	FieldingRecordService fieldingRecordService;
	
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
//		sponserservicel.getNonregsponsors().forEach((p)->{System.out.println(p.getUserId());});
		
//		SelectedPlayer x =  selectedPlayerRepo.findById(1).get();
//		

		

//		SelectedPlayer x =  selectedPlayerRepo.findById(1).get();
//		
//		Byte b =1;
		
//		BatmanRecord x2 = new BatmanRecord(null,100,57,4,7,b,x,b,b,b,b,b,b,0.0);
//		
//		batmanRecordService.saveRecord(x2);
//		
//		fieldingRecordService.saveRecord(new FieldingRecord(null,1,x,0.0));
		
//		BallerRecord baller = new BallerRecord(null,9.5,50,3,0,x,0.0);
//		
//		ballerRecordService.saveRecord(baller);
		
		
	}
	
}
