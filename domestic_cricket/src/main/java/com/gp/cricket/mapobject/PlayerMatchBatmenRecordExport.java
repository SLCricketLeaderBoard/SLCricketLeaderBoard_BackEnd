package com.gp.cricket.mapobject;

public class PlayerMatchBatmenRecordExport {

	private String tournamentName;
	private String matchtype;
	private String date;

	private String runs;
	private String faceBall;
	private String notOut;
	private String six;
	private String halfSentuary;
	private String sentuary;
	private String doubleSentuary;
	private String tripleSentuary;
	private String battingPoint;
	private String strikeRate;

	public PlayerMatchBatmenRecordExport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerMatchBatmenRecordExport(String tournamentName, String matchtype, String date, String runs,
			String faceBall, String notOut, String six, String halfSentuary, String sentuary, String doubleSentuary,
			String tripleSentuary, String battingPoint, String strikeRate) {
		super();
		this.tournamentName = tournamentName;
		this.matchtype = matchtype;
		this.date = date;
		this.runs = runs;
		this.faceBall = faceBall;
		this.notOut = notOut;
		this.six = six;
		this.halfSentuary = halfSentuary;
		this.sentuary = sentuary;
		this.doubleSentuary = doubleSentuary;
		this.tripleSentuary = tripleSentuary;
		this.battingPoint = battingPoint;
		this.strikeRate = strikeRate;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public String getMatchtype() {
		return matchtype;
	}

	public void setMatchtype(String matchtype) {
		this.matchtype = matchtype;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRuns() {
		return runs;
	}

	public void setRuns(String runs) {
		this.runs = runs;
	}

	public String getFaceBall() {
		return faceBall;
	}

	public void setFaceBall(String faceBall) {
		this.faceBall = faceBall;
	}

	public String getNotOut() {
		return notOut;
	}

	public void setNotOut(String notOut) {
		this.notOut = notOut;
	}

	public String getSix() {
		return six;
	}

	public void setSix(String six) {
		this.six = six;
	}

	public String getHalfSentuary() {
		return halfSentuary;
	}

	public void setHalfSentuary(String halfSentuary) {
		this.halfSentuary = halfSentuary;
	}

	public String getSentuary() {
		return sentuary;
	}

	public void setSentuary(String sentuary) {
		this.sentuary = sentuary;
	}

	public String getDoubleSentuary() {
		return doubleSentuary;
	}

	public void setDoubleSentuary(String doubleSentuary) {
		this.doubleSentuary = doubleSentuary;
	}

	public String getTripleSentuary() {
		return tripleSentuary;
	}

	public void setTripleSentuary(String tripleSentuary) {
		this.tripleSentuary = tripleSentuary;
	}

	public String getBattingPoint() {
		return battingPoint;
	}

	public void setBattingPoint(String battingPoint) {
		this.battingPoint = battingPoint;
	}

	public String getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(String strikeRate) {
		this.strikeRate = strikeRate;
	}

}
