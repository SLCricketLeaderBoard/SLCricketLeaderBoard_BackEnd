package com.gp.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.config.security.JwtInMemoryUserDetailsService;
import com.gp.cricket.entity.Manager;
import com.gp.cricket.entity.Referee;
import com.gp.cricket.entity.User;
import com.gp.cricket.repository.ManagerRepository;
import com.gp.cricket.repository.RefereeRepository;

@Service
public class RefereeService {

	@Autowired
	RefereeRepository refereeRepository;

	@Autowired
	UserService userService;

	@Autowired
	JwtInMemoryUserDetailsService jwtUser;

	// save manager first save user then save manager
	public Referee saveReferee(User user) {
		Byte x = 1;
		user.setStatus(x);
		User tempUser = userService.registerUser(user);
		Referee referee = new Referee(null, tempUser);
		return this.refereeRepository.save(referee);
	}

	public List<Referee> getAllReferees() {
		System.out.println("Get all referees here");
		return this.refereeRepository.findAll();

	}

	public List<Referee> getAvailableReferees() {
		return refereeRepository.getAvailableReferees();
	}

}
