package com.gp.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.cricket.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Integer>{
	
}
