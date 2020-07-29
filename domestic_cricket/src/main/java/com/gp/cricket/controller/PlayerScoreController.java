package com.gp.cricket.controller;


import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.mapobject.PlayerRate;
import com.gp.cricket.service.PlayerScoreService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class PlayerScoreController {
	
	@Autowired
	PlayerScoreService playerScoreService;

	@GetMapping("playerscore/{clubId}/{playerType}/{order}")
	public ResponseEntity<List<PlayerRate>> getPlayerRateList(@PathVariable("clubId") Integer clubId,
			@Min(0) @Max(2) @PathVariable("playerType") Integer playerType, @Min(0) @Max(2) @PathVariable("order") Integer order) {
		
		return ResponseEntity.ok(playerScoreService.getPlayerRateList(clubId, playerType, order));
	}

}
