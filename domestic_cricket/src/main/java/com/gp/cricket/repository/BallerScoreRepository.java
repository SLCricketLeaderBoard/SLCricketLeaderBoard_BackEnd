package com.gp.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.BallerRecord;
import com.gp.cricket.entity.BallerScore;

public interface BallerScoreRepository extends JpaRepository<BallerScore, Integer>{

	@Query("FROM BallerScore b WHERE b.playerId.playerId = :playerId AND b.matchTypeId.matchType =:matchType")
	BallerScore getRecordByPlayerIdMatchType(@Param("playerId")Integer playerId,@Param("matchType")String matchType);
	
//	BallerRecord getballerRecordBtSelectedPlayerId(@Param("selectedPlayerId")Integer selectedPlayerId);

}
