package com.gp.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.ClubRanking;

public interface ClubRankingRepository extends JpaRepository<ClubRanking, Integer>{

	@Query("FROM ClubRanking c WHERE c.clubId.clubId = :clubId AND c.matchTypeId.matchTypeId = :matchTypeId")
	public ClubRanking findByClubIdANDMatchType(@Param("clubId") Integer clubId,@Param("matchType") Integer matchType);

	
}
