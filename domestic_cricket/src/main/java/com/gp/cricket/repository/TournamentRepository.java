package com.gp.cricket.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.Club;
import com.gp.cricket.entity.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

	@Query("FROM Tournament t WHERE t.tournamentId = :tournamentId")
	Tournament findByTournamentId(@Param("tournamentId") Integer tournamentId);

	//////////////////// Hiernate code

	@Query("FROM Tournament t WHERE t.registartionCloseDate >:currenDate ORDER By t.startDate DESC")
	List<Tournament> pendingTournaments(@Param("currenDate") Date currenDate);
	
	@Query("FROM Tournament t WHERE t.registartionCloseDate <:currenDate ORDER By t.startDate DESC")
	List<Tournament> closedTournaments(@Param("currenDate") Date currenDate);

	@Query(value = "SELECT * FROM tournament  WHERE current_date() <= registration_closing_date AND "
				 + "tournament_id NOT IN (SELECT tournament_id FROM tournament_club  "
				 + "WHERE club_id = :clubId)", nativeQuery = true)
	List<Tournament> findUpcomingTournamentForClubByClubId(Club clubId);

	@Query("FROM Tournament t WHERE t.startDate >:currenDate ORDER By t.startDate ASC")
	List<Tournament> getTournamentByDateOrder(@Param("currenDate") Date currenDate);

	@Query("FROM Tournament t ORDER BY t.startDate ASC")
	List<Tournament> findAllTournaments();

	@Query("FROM Tournament t WHERE t.endDate < :date ORDER By t.startDate ASC ")
	List<Tournament> findPastTournament(@Param("date") Date date);
	
	@Query("FROM Tournament t WHERE t.startDate > :date ORDER By t.startDate ASC ")
	List<Tournament> findUpcomingTournament(@Param("date") Date date);
	
	@Query("FROM Tournament t WHERE t.startDate < :date AND t.endDate > :date ORDER By t.startDate ASC ")
	List<Tournament> findOnGoingTournament(@Param("date") Date date);
	
}
