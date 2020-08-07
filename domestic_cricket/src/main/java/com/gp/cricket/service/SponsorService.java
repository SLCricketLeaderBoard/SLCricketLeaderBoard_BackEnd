package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.config.security.JwtInMemoryUserDetailsService;
import com.gp.cricket.entity.Sponsor;
import com.gp.cricket.entity.User;
import com.gp.cricket.repository.SponsorRepository;
import com.gp.cricket.repository.UserRepository;

@Service
public class SponsorService {

	@Autowired
	SponsorRepository sponsorRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Autowired
	JwtInMemoryUserDetailsService jwtUser;
	
	public List<Sponsor>getNonregsponsors() {
		System.out.println("Get all non registered sponsors here");
		return this.sponsorRepository.getNonregsponsors();

	}
	
	public Integer sponsorAccept(Integer userId) {
		if (userId != null && userId > 0 && userRepository.existsById(userId)) {
			User user = userRepository.findByUserId(userId);
			user.setStatus((byte) 1);
			userRepository.save(user);
			return 1;
		}
		return null;
	}
}
