package com.gp.cricket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;

@Entity
public class Referee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="referee_id")
	private Integer refereeId;

	@NotNull
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User userId;
	
	

	public Referee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Referee(Integer refereeId, @NotNull User userId) {
		super();
		this.refereeId = refereeId;
		this.userId = userId;
	}

	public Integer getRefereeId() {
		return refereeId;
	}

	public void setRefereeId(Integer refereeId) {
		this.refereeId = refereeId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Referee [refereeId=" + refereeId + ", userId=" + userId + "]";
	}

}
