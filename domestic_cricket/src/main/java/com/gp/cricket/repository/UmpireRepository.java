package com.gp.cricket.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.gp.cricket.entity.Umpire;

public interface UmpireRepository extends  JpaRepository<Umpire, Integer>{
	@Query("FROM Umpire p WHERE p.userId.status=1 ")
	public List<Umpire> getAvailableUmpires();
}
