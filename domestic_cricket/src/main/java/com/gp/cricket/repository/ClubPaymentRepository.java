package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.Club;
import com.gp.cricket.entity.ClubPayment;

public interface ClubPaymentRepository extends JpaRepository<ClubPayment, Integer>{
	
	@Query("FROM ClubPayment c WHERE c.clubId = :clubId AND c.paymentForYear = :year")
	public ClubPayment findClubPaymentByClubIdAndYear(@Param("clubId") Club clubId,@Param("year") Integer year);
	
	@Query("FROM ClubPayment c WHERE c.clubId = :clubId ORDER BY c.paymentForYear DESC")
	public List<ClubPayment> findByClubId(@Param("clubId") Club clubId);

	@Query("FROM ClubPayment c WHERE c.clubId = :clubId AND c.paymentForYear = :year")
	public ClubPayment findByClubIdAndYear(@Param("clubId")Club club,@Param("year") Integer year);

}
