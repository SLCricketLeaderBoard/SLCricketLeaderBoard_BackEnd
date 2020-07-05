package com.gp.cricket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;

@Entity
public class Sponsor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sponsor_id")
	private Integer sponsorId;

	@NotNull
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User userId;
	
	public Sponsor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sponsor(Integer sponsorId, @NotNull User userId) {
		super();
		this.sponsorId = sponsorId;
		this.userId = userId;
	}
	
	public Integer getSponsorId() {
		return sponsorId;
	}
	
	public User getUserId() {
		return userId;
	}
	
}
