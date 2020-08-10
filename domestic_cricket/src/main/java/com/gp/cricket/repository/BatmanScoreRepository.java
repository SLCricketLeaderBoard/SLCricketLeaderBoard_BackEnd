package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.BallerScore;
import com.gp.cricket.entity.BatmanScore;
import com.gp.cricket.entity.Club;

public interface BatmanScoreRepository extends JpaRepository<BatmanScore, Integer>{

	@Query("FROM BatmanScore b WHERE b.playerId.playerId = :playerId AND b.matchTypeId.matchType =:matchType")
	BatmanScore getRecordByPlayerIdMatchType(@Param("playerId")Integer playerId,@Param("matchType")String matchType);

	@Query("FROM BatmanScore b WHERE b.playerId.clubId = :clubId "
			+ "AND b.matchTypeId.matchTypeId = :matchId "
			+ "AND b.playerId.specialType = :playerType "
			+ "ORDER BY b.points DESC")
	List<BatmanScore> findBatmenRating(@Param("clubId")Club club, @Param("matchId")Integer matchId,@Param("playerType") Integer playerType);

	@Query("FROM BatmanScore b WHERE b.playerId.playerId = :playerId AND b.matchTypeId.matchTypeId = :matchId ")
	BatmanScore findByMatchTypeANDPlayerId(@Param("playerId")Integer playerId,@Param("matchId") Integer matchId);
	
	@Query("FROM BatmanScore b WHERE b.matchTypeId.matchTypeId = :matchTypeId ORDER BY b.points DESC")
	List<BatmanScore> topBatmanPlayers(Integer matchTypeId);
}
