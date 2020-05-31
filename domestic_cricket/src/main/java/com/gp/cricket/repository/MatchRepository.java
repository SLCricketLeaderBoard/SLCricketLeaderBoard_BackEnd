package com.gp.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.cricket.entity.Match;

public interface MatchRepository extends JpaRepository<Match, Integer> {

}
