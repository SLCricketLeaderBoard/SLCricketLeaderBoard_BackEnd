package com.gp.cricket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class SponsorClub {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sponsor_club_id")
	private Integer sponsorClubId;

	@Column(name = "status")
	private Integer status;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "sponsor_id", referencedColumnName = "sponsor_id")
	private Sponsor sponsorId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "club_id", referencedColumnName = "club_id")
	private Club clubId;

	public SponsorClub() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SponsorClub(Integer sponsorClubId, Integer status, Sponsor sponsorId, Club clubId) {
		super();
		this.sponsorClubId = sponsorClubId;
		this.status = status;
		this.sponsorId = sponsorId;
		this.clubId = clubId;
	}

	public Integer getSponsorClubId() {
		return sponsorClubId;
	}

	public void setSponsorClubId(Integer sponsorClubId) {
		this.sponsorClubId = sponsorClubId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Sponsor getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Sponsor sponsorId) {
		this.sponsorId = sponsorId;
	}

	public Club getClubId() {
		return clubId;
	}

	public void setClubId(Club clubId) {
		this.clubId = clubId;
	}

}
