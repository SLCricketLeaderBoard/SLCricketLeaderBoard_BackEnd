package com.gp.cricket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "club_ranking")
public class ClubRanking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "club_ranking_id")
	private Integer clubRankingId;

	@NotNull
	private Double points;

	@NotNull
	private Double rating;

	@NotNull
	private Integer numMatch;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "club_id", referencedColumnName = "club_id")
	private Club clubId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "match_type_id", referencedColumnName = "match_type_id")
	private MatchType matchTypeId;

	public ClubRanking() {
		super();
	}

	public ClubRanking(Integer clubRankingId, Double points, Double rating, Integer numMatch, Club clubId,
			MatchType matchTypeId) {
		super();
		this.clubRankingId = clubRankingId;
		this.points = points;
		this.rating = rating;
		this.numMatch = numMatch;
		this.clubId = clubId;
		this.matchTypeId = matchTypeId;
	}

	public Integer getClubRankingId() {
		return clubRankingId;
	}

	public void setClubRankingId(Integer clubRankingId) {
		this.clubRankingId = clubRankingId;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getNumMatch() {
		return numMatch;
	}

	public void setNumMatch(Integer numMatch) {
		this.numMatch = numMatch;
	}

	public Club getClubId() {
		return clubId;
	}

	public void setClubId(Club clubId) {
		this.clubId = clubId;
	}

	public MatchType getMatchTypeId() {
		return matchTypeId;
	}

	public void setMatchTypeId(MatchType matchTypeId) {
		this.matchTypeId = matchTypeId;
	}

	@Override
	public String toString() {
		return "ClubRanking [clubRankingId=" + clubRankingId + ", points=" + points + ", rating=" + rating
				+ ", numMatch=" + numMatch + ", clubId=" + clubId + ", matchTypeId=" + matchTypeId + "]";
	}

}
