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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="player_id")
	private Integer playerId;

	/*
	 * 1 : Batman, 2 : Baller, 3 : AllRounder
	 */
	@NotBlank
	private String specialType;

	@NotNull
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User userId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "baller_type_id", referencedColumnName = "baller_type_id")
	private BallerType ballerTypeId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "batman_type_id", referencedColumnName = "batman_type_id")
	private BatmanType batmanTypeId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "club_id", referencedColumnName = "club_id")
	private Club clubId;

	public Player() {
	}

	public Player(Integer playerId, @NotNull String specialType, @NotNull User userId,
			@NotNull BallerType ballerTypeId, @NotNull BatmanType batmanTypeId, @NotNull Club clubId) {
		super();
		this.playerId = playerId;
		this.specialType = specialType;
		this.userId = userId;
		this.ballerTypeId = ballerTypeId;
		this.batmanTypeId = batmanTypeId;
		this.clubId = clubId;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public String getSpecialType() {
		return specialType;
	}

	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public BallerType getBallerTypeId() {
		return ballerTypeId;
	}

	public void setBallerTypeId(BallerType ballerTypeId) {
		this.ballerTypeId = ballerTypeId;
	}

	public BatmanType getBatmanTypeId() {
		return batmanTypeId;
	}

	public void setBatmanTypeId(BatmanType batmanTypeId) {
		this.batmanTypeId = batmanTypeId;
	}

	public Club getClubId() {
		return clubId;
	}

	public void setClubId(Club clubId) {
		this.clubId = clubId;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", specialType=" + specialType + ", userId=" + userId
				+ ", ballerTypeId=" + ballerTypeId + ", batmanTypeId=" + batmanTypeId + ", clubId=" + clubId + "]";
	}

}
