package com.gp.cricket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

	@Query("FROM Tournament t WHERE t.tournamentId = :tournamentId")
	Tournament findClubByTournamentId(@Param("tournamentId") Integer tournamentId);

	//////////////////// Hiernate code
	
	@Query("FROM Tournament t WHERE t.registartionCloseDate >:currenDate ORDER By t.startDate DESC")
	List<Tournament> pendingTournaments(@Param("currenDate") Date currenDate);
	
	@Query("FROM Tournament t WHERE t.registartionCloseDate <:currenDate ORDER By t.startDate DESC")
	List<Tournament> closedTournaments(@Param("currenDate") Date currenDate);
	
}
