package com.gp.cricket.mapobject;

public class PlayersData {

	private Integer playerId;
	private String playerName;
	private String club;

	public PlayersData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayersData(Integer playerId, String playerName, String club) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.club = club;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return "PlayersData [playerId=" + playerId + ", playerName=" + playerName + ", club=" + club + "]";
	}

}
