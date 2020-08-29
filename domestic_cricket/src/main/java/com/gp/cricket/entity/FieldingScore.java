package com.gp.cricket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fielding_score")
public class FieldingScore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fielding_id")
	private Integer fieldingId;
	
	@Column(name = "num_catches")
	private Integer numberOfCatch;
	
	@Column(name = "points")
	private Double points;
	
	@ManyToOne
	@JoinColumn(name = "player_id", referencedColumnName = "player_id")
	private Player playerId;
	
	@ManyToOne
	@JoinColumn(name = "match_type_id", referencedColumnName = "match_type_id")
	private MatchType matchTypeId;

	
	public FieldingScore() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public FieldingScore(Integer fieldingId, Integer numberOfCatch, Double fieldingPoints, Player playerId,
			MatchType matchTypeId) {
		super();
		this.fieldingId = fieldingId;
		this.numberOfCatch = numberOfCatch;
		this.points = fieldingPoints;
		this.playerId = playerId;
		this.matchTypeId = matchTypeId;
	}




	public Integer getFieldingId() {
		return fieldingId;
	}

	public void setFieldingId(Integer fieldingId) {
		this.fieldingId = fieldingId;
	}

	public Integer getNumberOfCatch() {
		return numberOfCatch;
	}

	public void setNumberOfCatch(Integer numberOfCatch) {
		this.numberOfCatch = numberOfCatch;
	}
	
	public void updateNumberOfCatch(Integer numberOfCatch) {
		this.numberOfCatch = this.numberOfCatch+numberOfCatch;
	}

	public Player getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Player playerId) {
		this.playerId = playerId;
	}

	public MatchType getMatchTypeId() {
		return matchTypeId;
	}

	public void setMatchTypeId(MatchType matchTypeId) {
		this.matchTypeId = matchTypeId;
	}

	public Double getFieldingPoints() {
		return points;
	}

	public void setFieldingPoints(Double fieldingPoints) {
		this.points = fieldingPoints;
	}




	public void updateFieldingPoints(Double fieldingPoints2) {
		this.points=this.points+fieldingPoints2;
		// TODO Auto-generated method stub
		
	}
	
	
}
