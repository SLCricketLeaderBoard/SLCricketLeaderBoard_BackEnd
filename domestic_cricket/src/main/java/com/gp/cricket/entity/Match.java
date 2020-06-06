package com.gp.cricket.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "match")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "match_id")
	private Integer matchId;
	
	@NotBlank(message = "Club1 id is mandatory")
	@Column(name = "club1_id")
	private Integer club1Id;
	
	@NotBlank(message = "Club2 name is mandatory")
	@Column(name = "club2_id")
	private Integer club2Id;
	
	@NotBlank(message = "Club1 captain name is mandatory")
	@Column(name = "captain_club1")
	private Integer captainClub1;
	

	@NotBlank(message = "Club2 captain name is mandatory")
	@Column(name = "captain_club2")
	private Integer captainClub2;
	

	@NotBlank(message = "Club1 mark is mandatory")	
	@Column(name = "club1_mark")
	private Integer club1mark;
	
	@NotBlank(message = "Club2 mark is mandatory")	
	@Column(name = "club2_mark")
	private Integer club2mark;
	
	@NotBlank(message = "Club1 wicket is mandatory")	
	@Column(name="club1_wicket")
	private Integer club1Wickets;
	
	@NotBlank(message = "Club2 wicket is mandatory")	
	@Column(name = "club2_wicket")
	private Integer club2Wickets;
	
	@NotBlank(message = "tournement round is mandotory")	
	@Column(name ="tournement_round")
	private Integer tournementRound;
	
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "MM-dd-YYYY")
	private LocalDate startDate;
	
	@Column(name="finish_date")
	@DateTimeFormat(pattern = "MM-dd-YYYY")
	private LocalDate finishDate;
	
	@Column(name = "start_time")
	private Date startTime;
	
	@Column(name="win_team")
	private Integer winTeam;
	
	@Column(name="sponsor")
	private String sponsor;
	
	@OneToOne
	@JoinColumn(name = "match_type_id", referencedColumnName = "match_type_id")
	private MatchType matchType;
	
	@OneToOne
	@JoinColumn(name = "stadium_id", referencedColumnName = "stadium_id")
	private Stadium stadium;
	
	
}
