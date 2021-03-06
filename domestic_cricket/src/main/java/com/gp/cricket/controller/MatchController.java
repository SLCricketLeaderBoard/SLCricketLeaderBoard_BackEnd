package com.gp.cricket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.Match;
import com.gp.cricket.entity.MatchType;
import com.gp.cricket.entity.Player;
import com.gp.cricket.service.MatchService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class MatchController {

	@Autowired
	MatchService matchService;

	// get match types test odi T20
	@GetMapping("/matchType")
	public List<MatchType> getMatchTypes() {
		return matchService.getMathcTypes();
	}

	@PostMapping("/createMatch")
	public Match createMathc(@Valid @RequestBody Match match) {
		System.out.println(match);
		return matchService.createMatch(match);
		// registerung managers
	}
	
	@PostMapping("/updateMatch")
	public Match updateMatch(@Valid @RequestBody Match match) {
		System.out.println(match);
		return matchService.updateMatch(match);
		// registerung managers
	}
	
	

	@GetMapping("/matches/{tournamentId}")
	public List<Match> getMatchesByTournamentId(@PathVariable("tournamentId") Integer tournamentId) {
		return matchService.findMatchesByTournamentId(tournamentId);
	}

//	 @GetMapping("matches")
//	 public List<Match> matchList (){
//		 return matchService.getMatchs();
//	 }

	// (u) this is function for getting a match by match id
	@GetMapping("/match/{matchId}")
	public Match getMatcheById(@PathVariable("matchId") Integer matchId) {
		return matchService.findMatchById(matchId);
	}

	@GetMapping("/match/players/{matchId}/{clubId}")
	public List<Player> getMatchePlayers(@PathVariable("matchId") Integer matchId,
			@PathVariable("clubId") Integer clubId) {
		return matchService.selectedPlayers(matchId, clubId);
	}

	// (u) this is for played matches according to the tournament id
	@GetMapping("/playedMatches/{tournamentId}")
	public List<Match> getPlayedMatches(@PathVariable("tournamentId") Integer tournamentId) {
		return matchService.playedMatches(tournamentId);
	}

	// (u) this is for to be played matches according to the tournament id
	@GetMapping("/toPlayMatches/{tournamentId}")
	public List<Match> getToPlayMatches(@PathVariable("tournamentId") Integer tournamentId) {
		return matchService.toPlayMatches(tournamentId);
	}

	@GetMapping("match/played/{clubId}")
	public ResponseEntity<List<Match>> getPlayedMatchList(@PathVariable("clubId") Integer clubId) {
		List<Match> result = matchService.getPlayedMatchList(clubId);
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("refereeMatchesUpcomming/{tournamentId}/{refereeId}")
	public List<Match> getRefereeMatchesUpcommig(@PathVariable("tournamentId") Integer tournamentId,
			@PathVariable("refereeId") Integer refereeId) {
		return matchService.refereeMatchesUpcomming(tournamentId, refereeId);
	}
	
	@GetMapping("getRefereeMatchesUpcommingOneDay/{tournamentId}/{refereeId}")
	public List<Match> getRefereeMatchesUpcommingOneDay(@PathVariable("tournamentId") Integer tournamentId,
			@PathVariable("refereeId") Integer refereeId) {
		return matchService.getRefereeMatchesUpcommingOneDay(tournamentId, refereeId);
	}
	
	@GetMapping("getRefereeMatchesUpcomming34Days/{tournamentId}/{refereeId}")
	public List<Match> getRefereeMatchesUpcomming34Days(@PathVariable("tournamentId") Integer tournamentId,
			@PathVariable("refereeId") Integer refereeId) {
		return matchService.getRefereeMatchesUpcomming34Days(tournamentId, refereeId);
	}
	
	@GetMapping("getRefereeMatchesUpcommingTTwenty/{tournamentId}/{refereeId}")
	public List<Match> getRefereeMatchesUpcommingTTwenty(@PathVariable("tournamentId") Integer tournamentId,
			@PathVariable("refereeId") Integer refereeId) {
		return matchService.getRefereeMatchesUpcommingTTwenty(tournamentId, refereeId);
	}


	@GetMapping("refereeMatchesPlayed/{tournamentId}/{refereeId}")
	public List<Match> getRefereeMatchesPlayed(@PathVariable("tournamentId") Integer tournamentId,
			@PathVariable("refereeId") Integer refereeId) {
		System.out.println("Played matches "+tournamentId+""+refereeId);
		return matchService.refereeMatchesPlayed(tournamentId, refereeId);
	}
	
	@GetMapping("getRefereeMatchesPlayedTTwenty/{tournamentId}/{refereeId}")
	public List<Match> getRefereeMatchesPlayedTTwenty(@PathVariable("tournamentId") Integer tournamentId,
			@PathVariable("refereeId") Integer refereeId) {
		System.out.println("Played matches "+tournamentId+""+refereeId);
		return matchService.getRefereeMatchesPlayedTTwenty(tournamentId, refereeId);
	}
	
	@GetMapping("getRefereeMatchesPlayedOneDay/{tournamentId}/{refereeId}")
	public List<Match> getRefereeMatchesPlayedOneDay(@PathVariable("tournamentId") Integer tournamentId,
			@PathVariable("refereeId") Integer refereeId) {
		System.out.println("Played matches "+tournamentId+""+refereeId);
		return matchService.getRefereeMatchesPlayedOneDay(tournamentId, refereeId);
	}
	
	@GetMapping("getRefereeMatchesPlayed34Days/{tournamentId}/{refereeId}")
	public List<Match> getRefereeMatchesPlayed34Days(@PathVariable("tournamentId") Integer tournamentId,
			@PathVariable("refereeId") Integer refereeId) {
		System.out.println("Played matches "+tournamentId+""+refereeId);
		return matchService.getRefereeMatchesPlayed34Days(tournamentId, refereeId);
	}
	
	@GetMapping("refereeMatchesPlayedUpdated/{tournamentId}/{refereeId}")
	public List<Match> getRefereeMatchesPlayedUpdated(@PathVariable("tournamentId") Integer tournamentId,
			@PathVariable("refereeId") Integer refereeId) {
		return matchService.refereeMatchesPlayedUpdated(tournamentId, refereeId);

	}
	
	@GetMapping("getRefereeMatchesPlayedUpdatedOneDay/{tournamentId}/{refereeId}")
	public List<Match> getRefereeMatchesPlayedUpdatedOneDay(@PathVariable("tournamentId") Integer tournamentId,
			@PathVariable("refereeId") Integer refereeId) {
		return matchService.getRefereeMatchesPlayedUpdatedOneDay(tournamentId, refereeId);

	}
	
	@GetMapping("getRefereeMatchesPlayedUpdated34Days/{tournamentId}/{refereeId}")
	public List<Match> getRefereeMatchesPlayedUpdated34Days(@PathVariable("tournamentId") Integer tournamentId,
			@PathVariable("refereeId") Integer refereeId) {
		return matchService.getRefereeMatchesPlayedUpdated34Days(tournamentId, refereeId);

	}
	
	@GetMapping("getRefereeMatchesPlayedUpdatedTTwenty/{tournamentId}/{refereeId}")
	public List<Match> getRefereeMatchesPlayedUpdatedTTwenty(@PathVariable("tournamentId") Integer tournamentId,
			@PathVariable("refereeId") Integer refereeId) {
		return matchService.getRefereeMatchesPlayedUpdatedTTwenty(tournamentId, refereeId);

	}
	
	@GetMapping("match/upcoming/{clubId}")
	public ResponseEntity<List<Match>> upComingMatchList(@PathVariable("clubId")Integer clubId){
		List<Match> result = matchService.upComingMatchList(clubId);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	
	
	@GetMapping("getLiveMatchTodayForReferee/{refreeId}")
	public ResponseEntity<List<Match>> getLivetodayMatchForReferee(@PathVariable("refreeId")String refreeId){
		int refId = Integer.parseInt(refreeId);
		List<Match> result = matchService.getLiveMatchForReferee(refId);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	

	@PostMapping("/updateMatchFor34Days")
	public Match updateMatchFor34Days(@Valid @RequestBody Match match) {
		System.out.println(match);
		return matchService.updateMatchFor34Days(match);
		// registerung managers
	}
	
}
