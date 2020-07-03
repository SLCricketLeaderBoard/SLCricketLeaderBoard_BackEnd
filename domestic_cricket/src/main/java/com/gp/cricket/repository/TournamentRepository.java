package com.gp.cricket.repository;

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

	@Query(value = "SELECT * FROM tournament  WHERE current_date() <= registration_closing_date AND "
				 + "tournament_id NOT IN (SELECT tournament_id FROM tournament_club  "
				 + "WHERE club_id = :clubId)", nativeQuery = true)
	List<Tournament> findUpcomingTournamentForClubByClubId(Club clubId);

}
