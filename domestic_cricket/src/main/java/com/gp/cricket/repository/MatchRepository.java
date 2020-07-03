package com.gp.cricket.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.Match;

public interface MatchRepository extends JpaRepository<Match, Integer> {

	@Query("FROM Match m WHERE m.tournamentId.tournamentId = :tournamentId ORDER BY m.tournementRound ASC")
	public List<Match> findMatchesByTournamentId(@Param("tournamentId") Integer tournamentId);

	@Query("FROM Match m WHERE m.matchId = :matchId")
	public Match findMatchById(@Param("matchId") Integer matchId);
	
	
	@Query("FROM Match m WHERE m.finishDate <:currentDate AND m.tournamentId.tournamentId = :tournamentId ORDER BY m.tournementRound ASC")
	public List<Match> getPlayedMatches(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId);
	
	@Query("FROM Match m WHERE m.finishDate >:currentDate AND m.tournamentId.tournamentId = :tournamentId ORDER BY m.tournementRound ASC")
	public List<Match> getToPlayMatches(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId);
	
}
