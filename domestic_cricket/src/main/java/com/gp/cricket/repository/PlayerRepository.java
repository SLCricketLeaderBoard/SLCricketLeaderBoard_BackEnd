package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.Club;
import com.gp.cricket.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
	@Query("FROM Player p WHERE p.clubId = :clubId AND p.userId.status = :status ORDER BY p.userId.nameWithInitial ASC")
	List<Player> findPlayerByClubId(@Param("clubId") Club clubId, @Param("status") Byte status);
	
	@Query("FROM Player p WHERE p.playerId = :playerId")
	Player findPlayerById(@Param("playerId") Integer playerId);
	
	@Query("SELECT p.userId.nic FROM Player p WHERE p.clubId = :clubId AND p.userId.status = 1")
	List<String> findPlayerByClubId(@Param("clubId") Club clubId);
	
}
