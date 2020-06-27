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

}
