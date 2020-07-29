package com.gp.cricket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.BatmanScore;
import com.gp.cricket.entity.Club;
import com.gp.cricket.entity.Player;
import com.gp.cricket.mapobject.PlayerRate;
import com.gp.cricket.repository.BallerScoreRepository;
import com.gp.cricket.repository.BatmanScoreRepository;
import com.gp.cricket.repository.ClubRepository;
import com.gp.cricket.repository.PlayerRepository;

@Service
public class PlayerScoreService {

	@Autowired
	BatmanScoreRepository batmanScoreRepository;

	@Autowired
	BallerScoreRepository ballerScoreRepository;

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	ClubRepository clubRepository;

	public List<PlayerRate> getPlayerRateList(Integer clubId, Integer playerType, Integer order) {

		List<PlayerRate> ratingList = new ArrayList<PlayerRate>();
		if (clubId != null && playerType != null && order != null) {
			Club club = clubRepository.findClubByClubId(clubId);
			List<Player> remainingList = new ArrayList<Player>();

			if (playerType == 1) {// Batmen
				// 1.Get ODI
				List<BatmanScore> batmenRatingListODI = batmanScoreRepository.findBatmenRating(club, 1);
				for (BatmanScore batmanScore : batmenRatingListODI) {
					PlayerRate ob = new PlayerRate();
					ob.setName(batmanScore.getPlayerId().getUserId().getNameWithInitial());
					ob.setRate1(batmanScore.getPoints());
					ob.setPlayerId(batmanScore.getPlayerId().getPlayerId());
					ratingList.add(ob);
				}

				// Get remaining players(They haven't ODI record yet)
				remainingList = playerRepository.findRemainingBatmenPlayers(club, playerType, 1);
				for (Player batmen : remainingList) {
					PlayerRate ob = new PlayerRate();
					ob.setName(batmen.getUserId().getNameWithInitial());
					ob.setRate1(0D);
					ob.setPlayerId(batmen.getPlayerId());
					ratingList.add(ob);
				}

				// 2.Get T20
				for (PlayerRate batmanScore : ratingList) {
					BatmanScore ob = batmanScoreRepository.findByMatchTypeANDPlayerId(batmanScore.getPlayerId(), 2);
					if (ob != null) {
						batmanScore.setRate2(ob.getPoints());
					} else {
						batmanScore.setRate2(0D);
					}
				}

				// 3.Get Test
				for (PlayerRate batmanScore : ratingList) {
					BatmanScore ob = batmanScoreRepository.findByMatchTypeANDPlayerId(batmanScore.getPlayerId(), 3);
					if (ob != null) {
						batmanScore.setRate3(ob.getPoints());
					} else {
						batmanScore.setRate3(0D);
					}
				}
			} else if (playerType == 2) {// Baller
				// 1.Get ODI
				List<BatmanScore> ballerRatingListODI = ballerScoreRepository.findBallerRating(club, 1);
				for (BatmanScore ballerScore : ballerRatingListODI) {
					PlayerRate ob = new PlayerRate();
					ob.setName(ballerScore.getPlayerId().getUserId().getNameWithInitial());
					ob.setRate1(ballerScore.getPoints());
					ob.setPlayerId(ballerScore.getPlayerId().getPlayerId());
					ratingList.add(ob);
				}

				// Get remaining players(They haven't ODI record yet)
				remainingList = playerRepository.findRemainingBallerPlayers(club, playerType, 1);
				for (Player baller : remainingList) {
					PlayerRate ob = new PlayerRate();
					ob.setName(baller.getUserId().getNameWithInitial());
					ob.setRate1(0D);
					ob.setPlayerId(baller.getPlayerId());
					ratingList.add(ob);
				}

				// 2.Get T20
				for (PlayerRate ballerScore : ratingList) {
					BatmanScore ob = ballerScoreRepository.findByMatchTypeANDPlayerId(ballerScore.getPlayerId(), 2);
					if (ob != null) {
						ballerScore.setRate2(ob.getPoints());
					} else {
						ballerScore.setRate2(0D);
					}
				}

				// 3.Get Test
				for (PlayerRate ballerScore : ratingList) {
					BatmanScore ob = ballerScoreRepository.findByMatchTypeANDPlayerId(ballerScore.getPlayerId(), 3);
					if (ob != null) {
						ballerScore.setRate3(ob.getPoints());
					} else {
						ballerScore.setRate3(0D);
					}
				}
			}else {//AllRounder
				
			}
		}

		return ratingList;
	}

}

class PlayerRateBasicData {
	Player playerId;
	Double strikeRate;

	public PlayerRateBasicData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerRateBasicData(Player playerId, Double strikeRate) {
		super();
		this.playerId = playerId;
		this.strikeRate = strikeRate;
	}

	public Player getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Player playerId) {
		this.playerId = playerId;
	}

	public Double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(Double strikeRate) {
		this.strikeRate = strikeRate;
	}

	@Override
	public String toString() {
		return "PlayerRateBasicData [playerId=" + playerId + ", strikeRate=" + strikeRate + "]";
	}

}
