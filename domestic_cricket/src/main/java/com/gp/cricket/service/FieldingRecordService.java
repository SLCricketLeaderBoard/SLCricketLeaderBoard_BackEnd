package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.FieldingRecord;
import com.gp.cricket.repository.FieldingRecordRepository;

@Service
public class FieldingRecordService {
	@Autowired
	FieldingRecordRepository fieldingRecordRepository;
	
	
	public FieldingRecord saveRecord(FieldingRecord record) {
		return fieldingRecordRepository.save(record);
	}


}
