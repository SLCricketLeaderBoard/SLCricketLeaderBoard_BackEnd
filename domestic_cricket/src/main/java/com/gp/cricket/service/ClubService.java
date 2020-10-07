package com.gp.cricket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Club;
import com.gp.cricket.repository.ClubRepository;
import com.gp.cricket.repository.ManagerRepository;
import com.gp.cricket.repository.PlayerRepository;

@Service
public class ClubService {

	@Autowired
	ClubRepository clubRepository;
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	ClubRankingService clubRankingService;
	

	public Integer clubRegister(Club club) {

		if (isValidClubObject(club)) {
			// check club name,email,contact_number,address use another club
			Club existClub = clubRepository.findClub(club.getClubName(), club.getEmail(), club.getContactNumber(),
					club.getAddress());
			if (existClub == null) {
				clubRepository.save(club);
				
				club = clubRepository.findClubByManagerId(club.getManagerId().getManagerId());
				//Create Ranking Object for club
				clubRankingService.createRankingObject(club);
				
				return 1;// save success
			}
			return 0;// There exist another club with same clubName or email or contactNum or address
		}
		return null;
	}

	public Integer clubUpdate(Club club) {
		if (isValidClubObject(club) && club.getClubId() > 0) {
			Club existClub = clubRepository.findClubByNotExistClubId(club.getClubName(), club.getEmail(),
					club.getContactNumber(), club.getAddress(), club.getClubId());

			if (existClub == null) {
				clubRepository.save(club);
				return 1;// update successful
			}
			return 0;// There exist another club with same clubName or email or contactNum or address
		}
		return null;
	}

	public List<Club> getClubs(Byte status) {
		return clubRepository.findByClubStatus(status);
	}

	public Optional<Club> getClubData(Integer clubId) {
		if (clubId != null && clubId > 0) {
			Optional<Club> object = clubRepository.findById(clubId);
			return object;
		}
		return null;
	}
	
	public Club getClubDataOfManager(Integer userId) {
		Club club = null;
		if(userId!=null && userId>0) {
			club = clubRepository.findClubByUserId(userId);
		}
		return club;
	}

	// club object validation
	private Boolean isValidClubObject(Club club) {
		if (club != null && club.getClubName() != null && club.getAddress() != null && club.getContactNumber() != null
				&& club.getEmail() != null && club.getManagerId() != null) {
			return true;
		}
		return false;
	}
	
	public List<String> getClubMembers(Integer clubId){
		if(clubId!=null && clubRepository.existsById(clubId)) {
			Club club = clubRepository.findClubByClubId(clubId);
			List<String> playerListNic = playerRepository.findPlayerByClubId(club);
			String managerNic = club.getManagerId().getUserId().getNic();
			playerListNic.add(managerNic);
			return playerListNic;
		}
		return null;
	}
}
