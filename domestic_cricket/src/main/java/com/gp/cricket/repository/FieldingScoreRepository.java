package com.gp.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.FieldingScore;

public interface FieldingScoreRepository extends JpaRepository<FieldingScore, Integer> {

	
	@Query("FROM FieldingScore b WHERE b.playerId.playerId = :playerId AND b.matchTypeId.matchType =:matchType")
	FieldingScore getRecordByPlayerIdMatchType(@Param("playerId")Integer playerId,@Param("matchType")String matchType);

}
