package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.gp.cricket.entity.Sponsor;


public interface SponsorRepository extends JpaRepository<Sponsor, Integer>{
	
	@Query("FROM Sponsor m WHERE  m.userId.status = 0")
	public List<Sponsor> getNonregsponsors();


}
