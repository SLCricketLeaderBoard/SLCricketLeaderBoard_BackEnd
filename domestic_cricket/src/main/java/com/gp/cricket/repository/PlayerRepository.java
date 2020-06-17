package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.Club;
import com.gp.cricket.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
	@Query("FROM Player p WHERE p.clubId = :clubId AND p.userId.status = 1")
	List<Player> findPlayerByClubId(@Param("clubId") Club clubId);
}
