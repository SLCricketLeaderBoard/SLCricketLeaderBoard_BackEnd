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
	private Integer club1Mark;
	
	@NotBlank(message = "Club2 mark is mandatory")	
	@Column(name = "club2_mark")
	private Integer club2Mark;
	
	@NotBlank(message = "Club1 wicket is mandatory")	
	@Column(name="club1_wicket")
	private Integer club1Wicket;
	
	@NotBlank(message = "Club2 wicket is mandatory")	
	@Column(name = "club2_wicket")
	private Integer club2Wicket;
	
	@NotBlank(message = "tournement round is mandotory")	
	@Column(name ="tournement_round")
	private Integer tournementRound;
	
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "MM-dd-YYYY")
	private LocalDate startdate;
	
	@Column(name="finish_date")
	@DateTimeFormat(pattern = "MM-dd-YYYY")
	private LocalDate finishDate;
	
	@Column(name = "start_time")
	private String startTime;
	
	@Column(name="win_team")
	private Integer winTeamId;
	
	@Column(name="sponsor")
	private String sponsor;
	
	@OneToOne
	@JoinColumn(name = "match_type_id", referencedColumnName = "match_type_id")
	private MatchType matchTypeId;
	
	@OneToOne
	@JoinColumn(name = "tournement_id", referencedColumnName = "tournement_id")
	private  Tournament tournamentId;
	
	@OneToOne
	@JoinColumn(name = "stadium_id", referencedColumnName = "stadium_id")
	private Stadium stadiumId;
	
	@OneToOne
	@JoinColumn(name = "referee_id", referencedColumnName = "referee_id")
	private Referee refereeId;
	
	@Column(name="umpire1_id")
	private Integer umpire1Id;

	@Column(name="umpire2_id")
	private Integer umpire2Id;

	@Column(name="umpire3_id")
	private Integer umpire3Id;

	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Match(Integer matchId, @NotBlank(message = "Club1 id is mandatory") Integer club1Id,
			@NotBlank(message = "Club2 name is mandatory") Integer club2Id,
			@NotBlank(message = "Club1 captain name is mandatory") Integer captainClub1,
			@NotBlank(message = "Club2 captain name is mandatory") Integer captainClub2,
			@NotBlank(message = "Club1 mark is mandatory") Integer club1Mark,
			@NotBlank(message = "Club2 mark is mandatory") Integer club2Mark,
			@NotBlank(message = "Club1 wicket is mandatory") Integer club1Wicket,
			@NotBlank(message = "Club2 wicket is mandatory") Integer club2Wicket,
			@NotBlank(message = "tournement round is mandotory") Integer tournementRound, LocalDate startdate,
			LocalDate finishDate, String startTime, Integer winTeamId, String sponsor, MatchType matchTypeId,
			Tournament tournamentId, Stadium stadiumId, Referee refereeId, Integer umpire1Id, Integer umpire2Id,
			Integer umpire3Id) {
		super();
		this.matchId = matchId;
		this.club1Id = club1Id;
		this.club2Id = club2Id;
		this.captainClub1 = captainClub1;
		this.captainClub2 = captainClub2;
		this.club1Mark = club1Mark;
		this.club2Mark = club2Mark;
		this.club1Wicket = club1Wicket;
		this.club2Wicket = club2Wicket;
		this.tournementRound = tournementRound;
		this.startdate = startdate;
		this.finishDate = finishDate;
		this.startTime = startTime;
		this.winTeamId = winTeamId;
		this.sponsor = sponsor;
		this.matchTypeId = matchTypeId;
		this.tournamentId = tournamentId;
		this.stadiumId = stadiumId;
		this.refereeId = refereeId;
		this.umpire1Id = umpire1Id;
		this.umpire2Id = umpire2Id;
		this.umpire3Id = umpire3Id;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public Integer getClub1Id() {
		return club1Id;
	}

	public void setClub1Id(Integer club1Id) {
		this.club1Id = club1Id;
	}

	public Integer getClub2Id() {
		return club2Id;
	}

	public void setClub2Id(Integer club2Id) {
		this.club2Id = club2Id;
	}

	public Integer getCaptainClub1() {
		return captainClub1;
	}

	public void setCaptainClub1(Integer captainClub1) {
		this.captainClub1 = captainClub1;
	}

	public Integer getCaptainClub2() {
		return captainClub2;
	}

	public void setCaptainClub2(Integer captainClub2) {
		this.captainClub2 = captainClub2;
	}

	public Integer getClub1Mark() {
		return club1Mark;
	}

	public void setClub1Mark(Integer club1Mark) {
		this.club1Mark = club1Mark;
	}

	public Integer getClub2Mark() {
		return club2Mark;
	}

	public void setClub2Mark(Integer club2Mark) {
		this.club2Mark = club2Mark;
	}

	public Integer getClub1Wicket() {
		return club1Wicket;
	}

	public void setClub1Wicket(Integer club1Wicket) {
		this.club1Wicket = club1Wicket;
	}

	public Integer getClub2Wicket() {
		return club2Wicket;
	}

	public void setClub2Wicket(Integer club2Wicket) {
		this.club2Wicket = club2Wicket;
	}

	public Integer getTournementRound() {
		return tournementRound;
	}

	public void setTournementRound(Integer tournementRound) {
		this.tournementRound = tournementRound;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getWinTeamId() {
		return winTeamId;
	}

	public void setWinTeamId(Integer winTeamId) {
		this.winTeamId = winTeamId;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public MatchType getMatchTypeId() {
		return matchTypeId;
	}

	public void setMatchTypeId(MatchType matchTypeId) {
		this.matchTypeId = matchTypeId;
	}

	public Tournament getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(Tournament tournamentId) {
		this.tournamentId = tournamentId;
	}

	public Stadium getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(Stadium stadiumId) {
		this.stadiumId = stadiumId;
	}

	public Referee getRefereeId() {
		return refereeId;
	}

	public void setRefereeId(Referee refereeId) {
		this.refereeId = refereeId;
	}

	public Integer getUmpire1Id() {
		return umpire1Id;
	}

	public void setUmpire1Id(Integer umpire1Id) {
		this.umpire1Id = umpire1Id;
	}

	public Integer getUmpire2Id() {
		return umpire2Id;
	}

	public void setUmpire2Id(Integer umpire2Id) {
		this.umpire2Id = umpire2Id;
	}

	public Integer getUmpire3Id() {
		return umpire3Id;
	}

	public void setUmpire3Id(Integer umpire3Id) {
		this.umpire3Id = umpire3Id;
	}

	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", club1Id=" + club1Id + ", club2Id=" + club2Id + ", captainClub1="
				+ captainClub1 + ", captainClub2=" + captainClub2 + ", club1Mark=" + club1Mark + ", club2Mark="
				+ club2Mark + ", club1Wicket=" + club1Wicket + ", club2Wicket=" + club2Wicket + ", tournementRound="
				+ tournementRound + ", startdate=" + startdate + ", finishDate=" + finishDate + ", startTime="
				+ startTime + ", winTeamId=" + winTeamId + ", sponsor=" + sponsor + ", matchTypeId=" + matchTypeId
				+ ", tournamentId=" + tournamentId + ", stadiumId=" + stadiumId + ", refereeId=" + refereeId
				+ ", umpire1Id=" + umpire1Id + ", umpire2Id=" + umpire2Id + ", umpire3Id=" + umpire3Id + "]";
	}

	
	
	
	
}
