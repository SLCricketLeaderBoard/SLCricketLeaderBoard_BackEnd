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
@Table(name = "batman_record")
public class BatmanRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "batman_record_id")
	private Integer batmanRecordId;
	
	
	@Column(name = "runs")
	private Integer battingRuns;
	
	@Column(name = "face_ball")
	private Integer facedBalls;
	
	@Column(name = "four")
	private Integer fours;
	
	@Column(name = "six")
	private Integer sixes;
	
	@Column(name = "not_out")
	private Byte notOut;
	
	@ManyToOne
	@JoinColumn(name = "selected_player_id", referencedColumnName = "selected_player_id")
	private SelectedPlayer selectedPlayerId;
	
	
	@Column(name = "half_sentury")
	private Byte halfentury;
	
	@Column(name = "sentury")
	private Byte sentury;
	
	@Column(name = "double_sentury")
	private Byte doubleSentury;
	
	@Column(name = "triple_sentury")
	private Byte tripleSentury;
	
	@Column(name = "fourble_sentury")
	private Byte foubleSentury;
	
	@Column(name = "fiveble_sentury")
	private Byte fivebleSentury;
	
	@Column(name = "batting_points")
	private Double battingPoints;

	public BatmanRecord() {
		super();
		// TODO Auto-generated constructor stub
	}







	public BatmanRecord(Integer batmanRecordId, Integer battingRuns, Integer facedBalls, Integer fours, Integer sixes,
			Byte notOut, SelectedPlayer selectedPlayerId, Byte halfentury, Byte sentury, Byte doubleSentury,
			Byte tripleSentury, Byte foubleSentury, Byte fivebleSentury, Double battingPoints) {
		super();
		this.batmanRecordId = batmanRecordId;
		this.battingRuns = battingRuns;
		this.facedBalls = facedBalls;
		this.fours = fours;
		this.sixes = sixes;
		this.notOut = notOut;
		this.selectedPlayerId = selectedPlayerId;
		this.halfentury = halfentury;
		this.sentury = sentury;
		this.doubleSentury = doubleSentury;
		this.tripleSentury = tripleSentury;
		this.foubleSentury = foubleSentury;
		this.fivebleSentury = fivebleSentury;
		this.battingPoints = battingPoints;
	}





	

	public Integer getBallerRecordId() {
		return batmanRecordId;
	}

	public void setBallerRecordId(Integer ballerRecordId) {
		this.batmanRecordId = ballerRecordId;
	}

	public Integer getBattingRuns() {
		return battingRuns;
	}

	public void setBattingRuns(Integer battingRuns) {
		this.battingRuns = battingRuns;
	}

	public Integer getFacedBalls() {
		return facedBalls;
	}

	public void setFacedBalls(Integer facedBalls) {
		this.facedBalls = facedBalls;
	}

	public Integer getFours() {
		return fours;
	}

	public void setFours(Integer fours) {
		this.fours = fours;
	}

	public Integer getSixes() {
		return sixes;
	}

	public void setSixes(Integer sixes) {
		this.sixes = sixes;
	}

	public Byte getNotOut() {
		return notOut;
	}

	public void setNotOut(Byte notOut) {
		this.notOut = notOut;
	}

	public SelectedPlayer getSelectedPlayerId() {
		return selectedPlayerId;
	}

	public void setSelectedPlayerId(SelectedPlayer selectedPlayerId) {
		this.selectedPlayerId = selectedPlayerId;
	}

	public Byte getHalfentury() {
		return halfentury;
	}

	public void setHalfentury(Byte halfentury) {
		this.halfentury = halfentury;
	}

	public Byte getSentury() {
		return sentury;
	}

	public void setSentury(Byte sentury) {
		this.sentury = sentury;
	}

	public Byte getDoubleSentury() {
		return doubleSentury;
	}

	public void setDoubleSentury(Byte doubleSentury) {
		this.doubleSentury = doubleSentury;
	}

	public Byte getTripleSentury() {
		return tripleSentury;
	}

	public void setTripleSentury(Byte tripleSentury) {
		this.tripleSentury = tripleSentury;
	}

	public Byte getFoubleSentury() {
		return foubleSentury;
	}

	public void setFoubleSentury(Byte foubleSentury) {
		this.foubleSentury = foubleSentury;
	}

	public Byte getFivebleSentury() {
		return fivebleSentury;
	}

	public void setFivebleSentury(Byte fivebleSentury) {
		this.fivebleSentury = fivebleSentury;
	}
	
	public Double getBattingPoints() {
		return battingPoints;
	}


	public void setBattingPoints(Double battingPoints) {
		this.battingPoints = battingPoints;
	}
	
}
