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
@Table(name = "baller_record")
public class BallerRecord {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "baller_record_id")
	private Integer ballerRecordId;
	
	@Column(name = "overs")
	private Double overs;
	
	@Column(name = "num_runs_against")
	private Integer numberOfRunsAgainst;
	
	@Column(name = "wicket")
	private Integer wickets;
	
	@Column(name = "hat_trick")
	private Integer hatTriks;
	
	@ManyToOne
	@JoinColumn(name = "selected_player_id", referencedColumnName = "selected_player_id")
	private SelectedPlayer selectedPlayerId;
	
	@Column(name = "balling_points")
	private Double ballingPoints;
	
	@Column(name = "num_of_wides")
	private Integer numberOfWides;
	
	@Column(name = "num_of_nos")
	private Integer numberOfNos;
	
	@Column(name = "avg_speed")
	private Double avgSpeed;
	

	public BallerRecord() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BallerRecord(Integer ballerRecordId, Double overs, Integer numberOfRunsAgainst, Integer wickets,
			Integer hatTriks, SelectedPlayer selectedPlayerId, Double ballingPoints, Integer numberOfWides,
			Integer numberOfNos, Double avgSpeed) {
		super();
		this.ballerRecordId = ballerRecordId;
		this.overs = overs;
		this.numberOfRunsAgainst = numberOfRunsAgainst;
		this.wickets = wickets;
		this.hatTriks = hatTriks;
		this.selectedPlayerId = selectedPlayerId;
		this.ballingPoints = ballingPoints;
		this.numberOfWides = numberOfWides;
		this.numberOfNos = numberOfNos;
		this.avgSpeed = avgSpeed;
	}



	public Integer getBallerRecordId() {
		return ballerRecordId;
	}

	public void setBallerRecordId(Integer ballerRecordId) {
		this.ballerRecordId = ballerRecordId;
	}

	public Double getOvers() {
		return overs;
	}

	public void setOvers(Double overs) {
		this.overs = overs;
	}

	public Integer getNumberOfRunsAgainst() {
		return numberOfRunsAgainst;
	}

	public void setNumberOfRunsAgainst(Integer numberOfRunsAgainst) {
		this.numberOfRunsAgainst = numberOfRunsAgainst;
	}

	public Integer getWickets() {
		return wickets;
	}

	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}

	public Integer getHatTriks() {
		return hatTriks;
	}

	public void setHatTriks(Integer hatTriks) {
		this.hatTriks = hatTriks;
	}

	public SelectedPlayer getSelectedPlayerId() {
		return selectedPlayerId;
	}

	public void setSelectedPlayerId(SelectedPlayer selectedPlayerId) {
		this.selectedPlayerId = selectedPlayerId;
	}

	public Double getBallingPoints() {
		return ballingPoints;
	}

	public void setBallingPoints(Double ballingPoints) {
		this.ballingPoints = ballingPoints;
	}



	public Integer getNumberOfWides() {
		return numberOfWides;
	}



	public void setNumberOfWides(Integer numberOfWides) {
		this.numberOfWides = numberOfWides;
	}



	public Integer getNumberOfNos() {
		return numberOfNos;
	}



	public void setNumberOfNos(Integer numberOfNos) {
		this.numberOfNos = numberOfNos;
	}



	public Double getAvgSpeed() {
		return avgSpeed;
	}



	public void setAvgSpeed(Double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	
	
	
	
	
}
