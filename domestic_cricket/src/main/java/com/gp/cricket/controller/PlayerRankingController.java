package com.gp.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.BallerScore;
import com.gp.cricket.entity.BatmanScore;
import com.gp.cricket.entity.FieldingScore;
import com.gp.cricket.service.PlayerRankingService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class PlayerRankingController {
	
	@Autowired
	PlayerRankingService playerRanking;
	
	@GetMapping("/playeRanking/topBallersOneDay")
	public List<BallerScore> getTopBallersOneDay() {
		return playerRanking.topBallerPlayers(1);
	}
	
	@GetMapping("/playeRanking/topBallers34Days")
	public List<BallerScore> getTopBallers34Days() {
		return playerRanking.topBallerPlayers(2);
	}
	
	@GetMapping("/playeRanking/topBallersT20")
	public List<BallerScore> getTopBallersT20() {
		return playerRanking.topBallerPlayers(3);
	}
	
	@GetMapping("/playeRanking/topBatmenOneDay")
	public List<BatmanScore> getTopBatmenOneDay() {
		return playerRanking.topBatmanPlayers(1);
	}
	
	@GetMapping("/playeRanking/topBatmen34Days")
	public List<BatmanScore> getTopBatmen34Days() {
		return playerRanking.topBatmanPlayers(2);
	}
	
	@GetMapping("/playeRanking/topBatmenT20")
	public List<BatmanScore> getTopBatmenT20() {
		return playerRanking.topBatmanPlayers(3);
	}
	
	@GetMapping("/playeRanking/topFilderOneDay")
	public List<FieldingScore> getTopFielderOneDay() {
		return playerRanking.topFieldingPlayers(1);
	}
	
	@GetMapping("/playeRanking/topFilder34Days")
	public List<FieldingScore> getTopFielder34Days() {
		return playerRanking.topFieldingPlayers(2);
	}
	
	@GetMapping("/playeRanking/topFilderT20")
	public List<FieldingScore> getTopFielderT20() {
		return playerRanking.topFieldingPlayers(3);
	}

}
