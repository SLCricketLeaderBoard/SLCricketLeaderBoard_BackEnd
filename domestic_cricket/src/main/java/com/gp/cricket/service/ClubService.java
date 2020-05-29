package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Club;
import com.gp.cricket.repository.ClubRepository;

@Service
public class ClubService {

	@Autowired
	ClubRepository clubRepository;

	public Integer clubRegister(Club club) {

		if (isValidClubObject(club)) {
			// check club name,email,contact_number,address use another club
			Club existClub = clubRepository.findClub(club.getClubName(), club.getEmail(), club.getContactNumber(),
					club.getAddress());
			if (existClub == null) {
				clubRepository.save(club);
				return 1;// save success
			}
			return 0;// There exist another club with same clubName or email or contactNum or address
		}
		return null;
	}

	// club object validation
	private Boolean isValidClubObject(Club club) {
		if (club != null && club.getClubName() != null && club.getAddress() != null && club.getContactNumber() != null
				&& club.getEmail() != null && club.getManagerId() != null) {
			return true;
		}
		return false;
	}
}
