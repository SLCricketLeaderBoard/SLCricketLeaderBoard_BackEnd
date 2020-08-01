package com.gp.cricket.mapobject;

import java.time.LocalDate;

public class PlayerMatchRecord {

	private Double points;
	private String date;

	public PlayerMatchRecord() {
		super();
	}

	public PlayerMatchRecord(Double points, String date) {
		super();
		this.points = points;
		this.date = date;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PlayerMatchRecord [points=" + points + ", date=" + date + "]";
	}

}
