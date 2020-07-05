package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.config.security.JwtInMemoryUserDetailsService;
import com.gp.cricket.entity.Sponsor;
import com.gp.cricket.entity.User;
import com.gp.cricket.repository.SponsorRepository;

@Service
public class SponsorService {

	@Autowired
	SponsorRepository sponsorRepository;

	@Autowired
	UserService userService;

	@Autowired
	JwtInMemoryUserDetailsService jwtUser;
	
	public List<Sponsor>getNonregsponsors() {
		System.out.println("Get all non registered sponsors here");
		return this.sponsorRepository.findAll();

	}
}
