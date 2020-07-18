package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.BatmanRecord;
import com.gp.cricket.repository.BatmanRecordRepository;

@Service
public class BatmanRecordService {
	
	@Autowired
	BatmanRecordRepository batmanRecordService;

	
	public BatmanRecord saveRecord(BatmanRecord record) {
		return batmanRecordService.save(record);
	}
	
	public BatmanRecord getbatmanRecordBtSelectedPlayerId(Integer selectedPlayerId) {
		return batmanRecordService.getbatmanRecordBtSelectedPlayerId(selectedPlayerId);
	}

}
