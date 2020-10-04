package com.gp.cricket.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.sun.istack.NotNull;

public class SponsorClub {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sponsor_club_id")
	private Integer sponsorClubId;
	
	@Column(name = "status")
	private Integer status;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "sponsor_id", referencedColumnName = "sponsor_id")
	private User sponsorId;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "club_id", referencedColumnName = "club_id")
	private User clubId;
}
