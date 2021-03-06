package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.Player;
import com.gp.cricket.entity.SelectedPlayer;

public interface SelectedPlayerRepository extends JpaRepository<SelectedPlayer, Integer>{

	@Query("SELECT s.playerId FROM SelectedPlayer s WHERE s.matchId.matchId =:matchId AND s.playerId.clubId.clubId =:clubId")
	List<Player>selectedPlayersForMatch(@Param("matchId") Integer matchId,@Param("clubId") Integer clubId);
	
	
	@Query("SELECT s FROM SelectedPlayer s WHERE s.matchId.matchId =:matchId AND s.playerId.clubId.clubId =:clubId")
	List<SelectedPlayer>selectedPlayersMatchIdClubId(@Param("matchId") Integer matchId,@Param("clubId") Integer clubId);
	
	@Query("SELECT s FROM SelectedPlayer s WHERE s.matchId.matchId =:matchId AND s.playerId.clubId.clubId =:clubId AND s.state=1")
	List<SelectedPlayer>selectedPlayersMatchIdClubIdUpdated(@Param("matchId") Integer matchId,@Param("clubId") Integer clubId);
	
	@Query("SELECT s FROM SelectedPlayer s WHERE s.matchId.matchId =:matchId AND s.playerId.clubId.clubId =:clubId AND s.state=0")
	List<SelectedPlayer>selectedPlayersMatchIdClubIdNotUpdated(@Param("matchId") Integer matchId,@Param("clubId") Integer clubId);
	
	
	
}
