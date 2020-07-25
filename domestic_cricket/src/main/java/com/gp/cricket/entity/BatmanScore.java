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
@Table(name = "batman_score")
public class BatmanScore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "batman_score_id")
	private Integer batmanScoreId;
	
	@Column(name= "match_count")
	private Integer matchCount;
	
	@Column(name = "not_out")
	private Integer notOut;
	
	@Column(name = "face_ball")
	private Integer facedBalls;
	
	@Column(name = "runs")
	private Integer runs;
	
	@Column(name = "four")
	private Integer four;
	
	@Column(name = "six")
	private Integer six;
	
	@ManyToOne
	@JoinColumn(name = "player_id", referencedColumnName = "player_id")
	private Player playerId;
	
	@ManyToOne
	@JoinColumn(name = "match_type_id", referencedColumnName = "match_type_id")
	private MatchType matchTypeId;
	
	@Column(name = "points")
	private Double points;
	
	@Column(name = "half_sentury")
	private Integer halfCenturies;
	
	@Column(name = "sentury")
	private Integer centuries;
	
	@Column(name = "double_sentury")
	private Integer doubleCenturies;
	
	@Column(name = "triple_sentury")
	private Integer tripleCenturies;
	
	@Column(name = "fourble_sentury")
	private Integer fourbleCenturies;
	
	@Column(name = "fiveble_sentury")
	private Integer fivebleCenturies;
	
	@Column(name = "strike_rate")
	private Double strikeRate;

	public BatmanScore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BatmanScore(Integer batmanScoreId, Integer matchCount, Integer notOut, Integer facedBalls, Integer runs,
			Integer four, Integer six, Player playerId, MatchType matchTypeId, Double points, Integer halfCenturies,
			Integer centuries, Integer doubleCenturies, Integer tripleCenturies, Integer fourbleCenturies,
			Integer fivebleCenturies, Double strikeRate) {
		super();
		this.batmanScoreId = batmanScoreId;
		this.matchCount = matchCount;
		this.notOut = notOut;
		this.facedBalls = facedBalls;
		this.runs = runs;
		this.four = four;
		this.six = six;
		this.playerId = playerId;
		this.matchTypeId = matchTypeId;
		this.points = points;
		this.halfCenturies = halfCenturies;
		this.centuries = centuries;
		this.doubleCenturies = doubleCenturies;
		this.tripleCenturies = tripleCenturies;
		this.fourbleCenturies = fourbleCenturies;
		this.fivebleCenturies = fivebleCenturies;
		this.strikeRate = strikeRate;
	}

	public Integer getBatmanScoreId() {
		return batmanScoreId;
	}

	public void setBatmanScoreId(Integer batmanScoreId) {
		this.batmanScoreId = batmanScoreId;
	}

	public Integer getMatchCount() {
		return matchCount;
	}

	public void setMatchCount(Integer matchCount) {
		this.matchCount = matchCount;
	}
	
	public void updateMatchCount(Integer matchCount) {
		this.matchCount =this.matchCount+ matchCount;
	}

	public Integer getNotOut() {
		return notOut;
	}

	public void setNotOut(Integer notOut) {
		this.notOut = notOut;
	}
	
	public void updateNotOut(Integer notOut) {
		this.notOut = this.notOut+notOut;
	}

	public Integer getFacedBalls() {
		return facedBalls;
	}

	public void setFacedBalls(Integer facedBalls) {
		this.facedBalls = facedBalls;
	}
	
	public void updateFacedBalls(Integer facedBalls) {
		this.facedBalls = this.facedBalls+facedBalls;
	}

	public Integer getRuns() {
		return runs;
	}

	public void setRuns(Integer runs) {
		this.runs = runs;
	}
	
	public void updateRuns(Integer runs) {
		this.runs = this.runs+runs;
	}

	public Integer getFour() {
		return four;
	}

	public void setFour(Integer four) {
		this.four = four;
	}
	
	public void updateFour(Integer four) {
		this.four =this.four+four;
	}

	public Integer getSix() {
		return six;
	}

	public void setSix(Integer six) {
		this.six = six;
	}
	
	public void updateSix(Integer six) {
		this.six = this.six+six;
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

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}
	
	public void updatePoints(Double points) {
		this.points = this.points+ points;
	}

	public Integer getHalfCenturies() {
		return halfCenturies;
	}

	public void setHalfCenturies(Integer halfCenturies) {
		this.halfCenturies = halfCenturies;
	}
	
	public void updateHalfCenturies(Integer halfCenturies) {
		this.halfCenturies = this.halfCenturies+halfCenturies;
	}

	public Integer getCenturies() {
		return centuries;
	}

	public void setCenturies(Integer centuries) {
		this.centuries = centuries;
	}
	
	public void updateCenturies(Integer centuries) {
		this.centuries =this.centuries+ centuries;
	}

	public Integer getDoubleCenturies() {
		return doubleCenturies;
	}

	public void setDoubleCenturies(Integer doubleCenturies) {
		this.doubleCenturies = doubleCenturies;
	}
	
	public void updateDoubleCenturies(Integer doubleCenturies) {
		this.doubleCenturies = this.doubleCenturies+doubleCenturies;
	}

	public Integer getTripleCenturies() {
		return tripleCenturies;
	}

	public void setTripleCenturies(Integer tripleCenturies) {
		this.tripleCenturies = tripleCenturies;
	}
	
	public void updateTripleCenturies(Integer tripleCenturies) {
		this.tripleCenturies = this.tripleCenturies+tripleCenturies;
	}


	public Integer getFourbleCenturies() {
		return fourbleCenturies;
	}

	public void setFourbleCenturies(Integer fourbleCenturies) {
		this.fourbleCenturies = fourbleCenturies;
	}
	
	public void updateFourbleCenturies(Integer fourbleCenturies) {
		this.fourbleCenturies = this.fourbleCenturies+fourbleCenturies;
	}

	public Integer getFivebleCenturies() {
		return fivebleCenturies;
	}

	public void setFivebleCenturies(Integer fivebleCenturies) {
		this.fivebleCenturies = fivebleCenturies;
	}
	
	public void updateFivebleCenturies(Integer fivebleCenturies) {
		this.fivebleCenturies = this.fivebleCenturies+fivebleCenturies;
	}

	public Double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(Double strikeRate) {
		this.strikeRate = strikeRate;
	}

}
