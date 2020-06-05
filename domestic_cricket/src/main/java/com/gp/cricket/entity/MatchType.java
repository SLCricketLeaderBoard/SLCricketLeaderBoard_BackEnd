package com.gp.cricket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "match_type")
public class MatchType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="match_type_id")
	private Integer matchTypeId;
	
	@Column(name = "match_type")
	private String type;

	public MatchType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatchType(Integer matchTypeId, String type) {
		super();
		this.matchTypeId = matchTypeId;
		this.type = type;
	}

	public Integer getMatchTypeId() {
		return matchTypeId;
	}

	public void setMatchTypeId(Integer matchTypeId) {
		this.matchTypeId = matchTypeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "MatchType [matchTypeId=" + matchTypeId + ", type=" + type + "]";
	}
	
	

}
