package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.Club;
import com.gp.cricket.entity.TournamentClub;

public interface TournamentClubRepository extends JpaRepository<TournamentClub, Integer> {

	@Query("FROM TournamentClub t WHERE t.clubId = :clubId ORDER By t.tournamentId.startDate DESC")
	List<TournamentClub> findByclubId(@Param("clubId") Club findClubByClubId);
	
	
	@Query("SELECT t.clubId FROM TournamentClub t WHERE t.tournamentId.tournamentId = :tournamentId AND t.status=1 ORDER By t.tournamentId.startDate DESC")
	List<Club>findClubsByTournamentId(@Param("tournamentId") Integer tournamentId);
	
	
	@Query("SELECT t.tournamentClubId FROM TournamentClub t WHERE t.tournamentId.tournamentId = :tournamentId AND t.clubId.clubId = :clubId  AND t.status=1  ORDER By t.tournamentId.startDate DESC")
	Integer findIdByTournamentAndClub(@Param("tournamentId") Integer tournamentId,@Param("clubId") Integer clubId);
	

}
