package com.gp.cricket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "selected_player")
public class SelectedPlayer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "selected_player_id")
	private Integer selectedPlayerId;
	
	@ManyToOne
	@JoinColumn(name = "match_id", referencedColumnName = "match_id")
	private Match matchId;
	
	@ManyToOne
	@JoinColumn(name = "player_id", referencedColumnName = "player_id")
	private Player playerId;

	public SelectedPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectedPlayer(Integer selectedPlayerId, Match matchId, Player playerId) {
		super();
		this.selectedPlayerId = selectedPlayerId;
		this.matchId = matchId;
		this.playerId = playerId;
	}

	public Integer getSelectedPlayerId() {
		return selectedPlayerId;
	}

	public void setSelectedPlayerId(Integer selectedPlayerId) {
		this.selectedPlayerId = selectedPlayerId;
	}

	public Match getMatchId() {
		return matchId;
	}

	public void setMatchId(Match matchId) {
		this.matchId = matchId;
	}

	public Player getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Player playerId) {
		this.playerId = playerId;
	}

	
}
