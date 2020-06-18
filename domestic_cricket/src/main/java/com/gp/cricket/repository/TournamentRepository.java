package com.gp.cricket.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.cricket.entity.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    //////////////////// Hiernate code

}
