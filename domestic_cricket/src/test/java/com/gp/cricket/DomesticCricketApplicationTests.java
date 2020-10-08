package com.gp.cricket;


import java.math.MathContext;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gp.cricket.controller.MatchController;
import com.gp.cricket.entity.BallerRecord;
import com.gp.cricket.entity.BatmanRecord;
import com.gp.cricket.entity.FieldingRecord;
import com.gp.cricket.entity.Match;
import com.gp.cricket.entity.MatchType;
import com.gp.cricket.entity.Player;
import com.gp.cricket.entity.Referee;
import com.gp.cricket.entity.SelectedPlayer;
import com.gp.cricket.entity.Stadium;
import com.gp.cricket.entity.Tournament;
import com.gp.cricket.repository.MatchRepository;
import com.gp.cricket.repository.MatchTypeRepository;
import com.gp.cricket.repository.RefereeRepository;
import com.gp.cricket.repository.SelectedPlayerRepository;
import com.gp.cricket.repository.StadiumRepository;
import com.gp.cricket.repository.TournamentClubPlayerRepository;
import com.gp.cricket.repository.TournamentClubRepository;
import com.gp.cricket.repository.TournamentRepository;
import com.gp.cricket.service.BallerRecordService;
import com.gp.cricket.service.BatmanRecordService;
import com.gp.cricket.service.FieldingRecordService;
import com.gp.cricket.service.MatchService;
import com.gp.cricket.service.PlayerRecordService;
import com.gp.cricket.service.SponsorService;
import com.gp.cricket.service.TournamentClubService;


@RunWith(SpringRunner.class)
@SpringBootTest
class DomesticCricketApplicationTests {

	@Test
	public void contextLoads() {
	}
	
}
