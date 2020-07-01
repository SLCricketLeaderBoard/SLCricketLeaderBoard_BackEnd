package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.Player;
import com.gp.cricket.entity.TournamentClubPlayer;

public interface TournamentClubPlayerRepository extends JpaRepository<TournamentClubPlayer, Integer>{

	@Query("SELECT t.playerId FROM TournamentClubPlayer t WHERE t.tournamentClubId.tournamentClubId = :tournamentClubId")
	List<Player> findPlayersForMatch(@Param("tournamentClubId") Integer tournamentClubId);
	
}
