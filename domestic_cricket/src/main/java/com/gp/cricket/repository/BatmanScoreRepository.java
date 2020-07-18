package com.gp.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.gp.cricket.entity.BatmanScore;

public interface BatmanScoreRepository extends JpaRepository<BatmanScore, Integer>{

	@Query("FROM BatmanScore b WHERE b.playerId.playerId = :playerId AND b.matchTypeId.matchType =:matchType")
	BatmanScore getRecordByPlayerIdMatchType(@Param("playerId")Integer playerId,@Param("matchType")String matchType);
}
