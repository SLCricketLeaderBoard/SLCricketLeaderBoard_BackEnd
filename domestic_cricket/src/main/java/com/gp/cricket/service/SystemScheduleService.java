package com.gp.cricket.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.gp.cricket.repository.ClubPaymentRepository;
import com.gp.cricket.repository.ClubRepository;


@Service
@EnableScheduling
public class SystemScheduleService {
	
	@Autowired
	ClubPaymentRepository clubPaymentRepository;
	
	@Autowired
	ClubRepository clubRepository;
	
//	@Scheduled(cron="0 0 12 5 1 ? *")
//	public void checkClubPayment() {
//		
//	}

}
