package com.gp.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.BallerRecord;


public interface BallerRecordRepository extends JpaRepository<BallerRecord,Integer>{

	@Query("FROM BallerRecord b WHERE b.selectedPlayerId.selectedPlayerId = :selectedPlayerId")
	BallerRecord getballerRecordBtSelectedPlayerId(@Param("selectedPlayerId")Integer selectedPlayerId);

}
