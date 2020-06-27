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
@Table(name = "tournament_club_player")
public class TournamentClubPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tournament_club_player_id")
	private Integer tournamentClubPlayerId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "tournament_club_id", referencedColumnName = "tournament_club_id")
	private TournamentClub tournamentClubId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "player_id", referencedColumnName = "player_id")
	private Player playerId;

	public TournamentClubPlayer() {
	}

	public TournamentClubPlayer(Integer tournamentClubPlayerId, @NotNull TournamentClub tournamentClubId,
			@NotNull Player playerId) {
		super();
		this.tournamentClubPlayerId = tournamentClubPlayerId;
		this.tournamentClubId = tournamentClubId;
		this.playerId = playerId;
	}

	public Integer getTournamentClubPlayerId() {
		return tournamentClubPlayerId;
	}

	public void setTournamentClubPlayerId(Integer tournamentClubPlayerId) {
		this.tournamentClubPlayerId = tournamentClubPlayerId;
	}

	public TournamentClub getTournamentClubId() {
		return tournamentClubId;
	}

	public void setTournamentClubId(TournamentClub tournamentClubId) {
		this.tournamentClubId = tournamentClubId;
	}

	public Player getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Player playerId) {
		this.playerId = playerId;
	}

	@Override
	public String toString() {
		return "TournamentClubPlayer [tournamentClubPlayerId=" + tournamentClubPlayerId + ", tournamentClubId="
				+ tournamentClubId + ", playerId=" + playerId + "]";
	}

}
