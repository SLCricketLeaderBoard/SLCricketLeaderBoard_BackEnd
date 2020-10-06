package com.gp.cricket.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge=3600)
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("report/club")
	public ResponseEntity<Map<String, String>> getClubReport() throws JRException, IOException {
		String path =  reportService.getClubReport("pdf");
		Map<String, String> response = new HashMap<String, String>();
		response.put("fileName", path);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("report/club/payment/{year}")
	public ResponseEntity<Map<String, String>> getClubPaymentReport(@PathVariable("year") Integer year) throws JRException, IOException {
		String path =  reportService.getClubPaymentReport("pdf", year);
		Map<String, String> response = new HashMap<String, String>();
		response.put("fileName", path);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("report/tournament/{type}")
	public ResponseEntity<Map<String, String>> getTournamentReport(@PathVariable("type") Integer type) throws JRException, IOException {
		String path =  reportService.getTournamentReport("pdf", type);
		Map<String, String> response = new HashMap<String, String>();
		response.put("fileName", path);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("report/tournament/match/{tournamentId}")
	public ResponseEntity<Map<String, String>> getTournamentMatchPast(@PathVariable("tournamentId") Integer tournamentId) throws JRException, IOException {
		String path =  reportService.getTournamentMatchPast("pdf", tournamentId);
		Map<String, String> response = new HashMap<String, String>();
		response.put("fileName", path);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("report/tournament/match/{tournamentId}/{type}")
	public ResponseEntity<Map<String, String>> getTournamentMatchFuture(@PathVariable("tournamentId") Integer tournamentId,@PathVariable("type") Integer type) throws JRException, IOException {
		String path =  reportService.getTournamentMatchFuture("pdf", tournamentId,type);
		Map<String, String> response = new HashMap<String, String>();
		response.put("fileName", path);
		return ResponseEntity.ok(response);
	}
	
	
	
}
