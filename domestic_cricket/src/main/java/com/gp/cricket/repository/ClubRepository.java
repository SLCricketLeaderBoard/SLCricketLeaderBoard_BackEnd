package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Integer>{
	
	@Query("FROM Club c WHERE c.clubName = :clubName OR c.email = :email OR c.contactNumber = :contactNum OR address = :address")
	public Club findClub(@Param("clubName") String clubName, @Param("email")String email, @Param("contactNum")String contactNum, @Param("address")String address);

	@Query("FROM Club c WHERE (c.clubName = :clubName OR c.email = :email OR c.contactNumber = :contactNum OR address = :address) AND (c.clubId NOT IN (:clubId) )")
	public Club findClubByNotExistClubId(@Param("clubName") String clubName, @Param("email")String email, @Param("contactNum")String contactNum, @Param("address")String address, @Param("clubId") Integer clubId);

	@Query("FROM Club c WHERE c.managerId.userId.userId = :userId")
	public Club findClubByUserId(@Param("userId") Integer userId);
	
	@Query("FROM Club c WHERE c.status = :status")
	public List<Club> findByClubStatus(@Param("status") Byte status);
	
	@Query("FROM Club c WHERE c.clubId = :clubId")
	public Club findClubByClubId(@Param("clubId") Integer clubId);
}	


