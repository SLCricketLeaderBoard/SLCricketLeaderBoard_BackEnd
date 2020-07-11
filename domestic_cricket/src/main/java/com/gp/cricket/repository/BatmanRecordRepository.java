package com.gp.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.BatmanRecord;


public interface BatmanRecordRepository extends JpaRepository<BatmanRecord, Integer> {

	@Query("FROM BatmanRecord b WHERE b.selectedPlayerId.selectedPlayerId = :selectedPlayerId")
	public BatmanRecord getbatmanRecordBtSelectedPlayerId(@Param("selectedPlayerId")Integer selectedPlayerId);
}
