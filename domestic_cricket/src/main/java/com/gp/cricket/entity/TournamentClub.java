package com.gp.cricket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tournament_club")
public class TournamentClub {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tournament_club_id")
	private Integer tournamentClubId;

	@NotNull
	private Byte status;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "club_id", referencedColumnName = "club_id")
	private Club clubId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "tournament_id", referencedColumnName = "tournament_id")
	private Tournament tournamentId;
	
	

	public TournamentClub() {
		
	}

	public TournamentClub(Integer tournamentClubId, @NotNull Byte status, @NotNull Club clubId,
			@NotNull Tournament tournamentId) {
		super();
		this.tournamentClubId = tournamentClubId;
		this.status = status;
		this.clubId = clubId;
		this.tournamentId = tournamentId;
	}

	public Integer getTournamentClubId() {
		return tournamentClubId;
	}

	public void setTournamentClubId(Integer tournamentClubId) {
		this.tournamentClubId = tournamentClubId;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Club getClubId() {
		return clubId;
	}

	public void setClubId(Club clubId) {
		this.clubId = clubId;
	}

	public Tournament getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(Tournament tournamentId) {
		this.tournamentId = tournamentId;
	}

	@Override
	public String toString() {
		return "TournamentClub [tournamentClubId=" + tournamentClubId + ", status=" + status + ", clubId=" + clubId
				+ ", tournamentId=" + tournamentId + "]";
	}

}
