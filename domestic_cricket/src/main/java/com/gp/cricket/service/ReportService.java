package com.gp.cricket.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.gp.cricket.entity.Club;
import com.gp.cricket.report.entity.ClubReport;
import com.gp.cricket.repository.ClubRepository;
import com.gp.cricket.repository.PlayerRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

	@Autowired
	ClubRepository clubRepository;

	@Autowired
	PlayerRepository playerRepository;

	private final String path = "D:\\UCSC\\Third year\\FirstSemester\\Group Project II\\Implementation\\Git_Implement\\SLCricketLeaderBoard_FrontEnd\\domestic_cricket\\src\\assets\\reports\\";
	String filePath = "";

	public String getClubReport(String reportFormat) throws JRException, IOException {
		List<ClubReport> clubReportData = new ArrayList<ClubReport>();
		List<Club> clubList = clubRepository.findAll();
		String fileName = "";

		for (Club club : clubList) {
			ClubReport ob = new ClubReport();
			ob.setClubId(club.getClubId());
			ob.setClubName(club.getClubName());
			ob.setManager(club.getManagerId().getUserId().getNameWithInitial());
			ob.setNumPlayer(getNumerofPlayers(club));
			ob.setRegDate(club.getRegDate().toString());

			clubReportData.add(ob);
		}

		// Load the file and compiler it
		File file = ResourceUtils.getFile("classpath:clubFormat.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(clubReportData);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("Created by", "Nuwan");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		if (reportFormat.equalsIgnoreCase("pdf")) {
			fileName = "Club_Report_"+getCurrentDate()+".pdf";
			filePath = path + fileName;
			JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);
		}

		return fileName;
	}

	private Integer getNumerofPlayers(Club club) {
		Integer numPlayer = 0;
		numPlayer = playerRepository.getNumofPlayerinClub(club);
		return numPlayer;
	}

	private String getCurrentDate() {
		LocalDate today = LocalDate.now();
		return today.toString();
	}

}
