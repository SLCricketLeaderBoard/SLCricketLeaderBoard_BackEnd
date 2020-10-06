package com.gp.cricket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.Player;
import com.gp.cricket.mapobject.PlayerMatchData;
import com.gp.cricket.service.PlayerService;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge=3600)
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
	@PostMapping("player/signup")
	public ResponseEntity<Integer> playerSignUp(@Valid @RequestBody Player player){
		Integer result = playerService.playerSignup(player);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("player")
	public ResponseEntity<Integer> playerUpdate(@Valid @RequestBody Player player){
		Integer result = playerService.playerUpdate(player);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("player/club/{clubId}/{status}")
	public ResponseEntity<List<Player>> getClubPlayerList(@PathVariable("clubId")Integer clubId,@PathVariable("status") Byte status){
		List<Player> result = playerService.getClubPlayerList(clubId,status);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("player/{playerId}")
	public ResponseEntity<Player> getPlayer(@PathVariable("playerId") Integer playerId){
		Player result = playerService.getPlayer(playerId);
		if(playerId!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("player/deactivate/{playerId}")
	public ResponseEntity<Integer> playerAccountDeactivate(@PathVariable("playerId")Integer playerId){
		Integer result = playerService.playerAccountDeactivate(playerId);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("player/match/data/{playerType}/{userId}")
	public List<PlayerMatchData> getPlayerMatchData(@PathVariable("playerType")Integer playerType,@PathVariable("userId")Integer userId){
		return playerService.getPlayerMatchData(playerType, userId);
	}

}
