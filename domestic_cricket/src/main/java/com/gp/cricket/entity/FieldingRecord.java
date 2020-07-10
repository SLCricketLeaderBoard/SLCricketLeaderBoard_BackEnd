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
@Table(name = "fielding_record")
public class FieldingRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fielding_record_id")
	private Integer fieldingRecordId;
	
	
	@Column(name = "catch")
	private Integer catches;
	
	@ManyToOne
	@JoinColumn(name = "selected_player_id", referencedColumnName = "selected_player_id")
	private SelectedPlayer selectedPlayerId;
	
	@Column(name = "fielding_points")
	private Double fieldingPoints;
	

	public FieldingRecord() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public FieldingRecord(Integer fieldingRecordId, Integer catches, SelectedPlayer selectedPlayerId,
			Double fieldingPoints) {
		super();
		this.fieldingRecordId = fieldingRecordId;
		this.catches = catches;
		this.selectedPlayerId = selectedPlayerId;
		this.fieldingPoints = fieldingPoints;
	}



	public Integer getFieldingRecordId() {
		return fieldingRecordId;
	}

	public void setFieldingRecordId(Integer fieldingRecordId) {
		this.fieldingRecordId = fieldingRecordId;
	}

	public Integer getCatches() {
		return catches;
	}

	public void setCatches(Integer catches) {
		this.catches = catches;
	}

	public SelectedPlayer getSelectedPlayerId() {
		return selectedPlayerId;
	}

	public void setSelectedPlayerId(SelectedPlayer selectedPlayerId) {
		this.selectedPlayerId = selectedPlayerId;
	}

	public Double getFieldingPoints() {
		return fieldingPoints;
	}

	public void setFieldingPoints(Double fieldingPoints) {
		this.fieldingPoints = fieldingPoints;
	}
	
	

	
	
	
}
