package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.BallerRecord;
import com.gp.cricket.repository.BallerRecordRepository;

@Service
public class BallerRecordService {
	
	@Autowired
	BallerRecordRepository ballerRecordRepo;
	
	public BallerRecord saveRecord(BallerRecord record) {
		return ballerRecordRepo.save(record);
	}

}
