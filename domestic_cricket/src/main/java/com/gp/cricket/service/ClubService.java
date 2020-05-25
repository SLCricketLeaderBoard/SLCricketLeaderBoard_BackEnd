package com.gp.cricket.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gp.cricket.entity.Club;
import com.gp.cricket.repository.ClubRepository;

@Service
@Validated
public class ClubService {

	@Autowired
	ClubRepository clubRepository;

	public Integer clubRegister(Club club) {

		// check club name,email,contact_number,address use another club
		Club existClub = clubRepository.findClub(club.getClubName(), club.getEmail(), club.getContactNumber(),
				club.getAddress());
		if (existClub == null) {
			clubRepository.save(club);
			return 1;// save success
		}
		return 0;// There exist another club with same clubName or email or contactNum or address
	}
}
