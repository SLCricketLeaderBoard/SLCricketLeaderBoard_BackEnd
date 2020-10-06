package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.BallerRecord;
import com.gp.cricket.entity.Match;


public interface BallerRecordRepository extends JpaRepository<BallerRecord,Integer>{

	@Query("FROM BallerRecord b WHERE b.selectedPlayerId.selectedPlayerId = :selectedPlayerId")
	BallerRecord getballerRecordBtSelectedPlayerId(@Param("selectedPlayerId")Integer selectedPlayerId);

	@Query("FROM BallerRecord b WHERE b.selectedPlayerId.playerId.playerId = :playerId AND "
			+ "b.selectedPlayerId.matchId.matchTypeId.matchTypeId = :matchType "
			+ "ORDER BY b.selectedPlayerId.matchId.finishDate DESC")
	List<BallerRecord> findByPlayerIdANDMatchType(Integer playerId, Integer matchType);

	@Query("FROM BallerRecord b WHERE b.selectedPlayerId.playerId.playerId = :playerId AND "
			+ "b.selectedPlayerId.matchId = :matchId")
	BallerRecord findByPlayerIdANDMatchId(@Param("playerId")Integer playerId,@Param("matchId") Match matchId);

	@Query("FROM BallerRecord b WHERE b.selectedPlayerId.playerId.playerId = :userId")
	List<BallerRecord> findByUserId(@Param("userId") Integer userId);

}
