package com.gp.cricket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.Player;
import com.gp.cricket.service.PlayerService;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge=3600)
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
	@PostMapping("player")
	public ResponseEntity<Integer> playerRegister(@Valid @RequestBody Player player){
		Integer result = playerService.playerRegister(player);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("player/club/{clubId}")
	public ResponseEntity<List<Player>> getClubPlayerList(@PathVariable("clubId")Integer clubId){
		List<Player> result = playerService.getClubPlayerList(clubId);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
}
