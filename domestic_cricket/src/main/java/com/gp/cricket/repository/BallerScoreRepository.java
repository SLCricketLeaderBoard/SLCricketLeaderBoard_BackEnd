package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.BallerRecord;
import com.gp.cricket.entity.BallerScore;
import com.gp.cricket.entity.BatmanScore;
import com.gp.cricket.entity.Club;

public interface BallerScoreRepository extends JpaRepository<BallerScore, Integer>{

	@Query("FROM BallerScore b WHERE b.playerId.playerId = :playerId AND b.matchTypeId.matchType =:matchType")
	BallerScore getRecordByPlayerIdMatchType(@Param("playerId")Integer playerId,@Param("matchType")String matchType);

	
	@Query("FROM BallerScore b WHERE b.playerId.clubId = :clubId "
			+ "AND b.matchTypeId.matchTypeId = :matchTypeId "
			+ "AND b.playerId.specialType = :playerType "
			+ "ORDER BY b.points DESC")
	List<BallerScore> findBallerRating(@Param("clubId")Club clubId,@Param("matchTypeId")Integer matchTypeId,@Param("playerType") Integer playerType);

	
	@Query("FROM BallerScore b WHERE b.playerId.playerId = :playerId AND b.matchTypeId.matchTypeId = :matchId ")
	BallerScore findByMatchTypeANDPlayerId(@Param("playerId")Integer playerId,@Param("matchId") Integer matchId);

	@Query("FROM BallerScore b WHERE b.matchTypeId.matchTypeId = :matchTypeId ORDER BY b.points DESC")
	List<BallerScore> topBallerPlayers(Integer matchTypeId);

	@Query("FROM BallerScore b WHERE b.playerId.playerId= :playerId")
	BallerScore getDetailsByPlayerId(Integer playerId);
	

}
