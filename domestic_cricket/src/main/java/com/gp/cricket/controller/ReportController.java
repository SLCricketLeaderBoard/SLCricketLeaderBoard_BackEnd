package com.gp.cricket.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
