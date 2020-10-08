package com.gp.cricket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "tournament_club_captain")
public class TournamentClubCaptain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tournamentClubCaptainId;

	@NotNull
	private Integer captainId;// player table id

	@NotNull
	private Integer viceCaptainId;// player table id

	@OneToOne
	@JoinColumn(name = "tournament_club_id", referencedColumnName = "tournament_club_id")
	private TournamentClub tournamentClubId;

	public TournamentClubCaptain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TournamentClubCaptain(Integer tournamentClubCaptainId, Integer captainId, Integer viceCaptainId,
			TournamentClub tournamentClubId) {
		super();
		this.tournamentClubCaptainId = tournamentClubCaptainId;
		this.captainId = captainId;
		this.viceCaptainId = viceCaptainId;
		this.tournamentClubId = tournamentClubId;
	}

	public Integer getTournamentClubCaptainId() {
		return tournamentClubCaptainId;
	}

	public void setTournamentClubCaptainId(Integer tournamentClubCaptainId) {
		this.tournamentClubCaptainId = tournamentClubCaptainId;
	}

	public Integer getCaptainId() {
		return captainId;
	}

	public void setCaptainId(Integer captainId) {
		this.captainId = captainId;
	}

	public Integer getViceCaptainId() {
		return viceCaptainId;
	}

	public void setViceCaptainId(Integer viceCaptainId) {
		this.viceCaptainId = viceCaptainId;
	}

	public TournamentClub getTournamentClubId() {
		return tournamentClubId;
	}

	public void setTournamentClubId(TournamentClub tournamentClubId) {
		this.tournamentClubId = tournamentClubId;
	}

	@Override
	public String toString() {
		return "TournamentClubCaptain [tournamentClubCaptainId=" + tournamentClubCaptainId + ", captainId=" + captainId
				+ ", viceCaptainId=" + viceCaptainId + ", tournamentClubId=" + tournamentClubId + "]";
	}

}
