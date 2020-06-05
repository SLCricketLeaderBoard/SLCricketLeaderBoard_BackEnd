package com.gp.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.Stadium;

public interface StadiumRepository extends JpaRepository<Stadium, Integer>{
	
//	@Query("FROM Stadium c WHERE c.name = :name OR c.address = :address OR contactnum = :contactnum")
//	public Stadium findStadium(@Param("name") String name, @Param("address")String address, @Param("contactnum")String contactnum, @Param("capacity")String capacity);

}	


