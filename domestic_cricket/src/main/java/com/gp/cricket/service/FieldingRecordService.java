package com.gp.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.BallerScore;
import com.gp.cricket.entity.BatmanRecord;
import com.gp.cricket.entity.BatmanScore;
import com.gp.cricket.entity.FieldingRecord;
import com.gp.cricket.entity.FieldingScore;
import com.gp.cricket.repository.FieldingRecordRepository;
import com.gp.cricket.repository.FieldingScoreRepository;

@Service
public class FieldingRecordService {
	@Autowired
	FieldingRecordRepository fieldingRecordRepository;
	
	@Autowired
	FieldingScoreService fieldingScoreService;
	
	
	public FieldingRecord saveRecord(FieldingRecord record) {
		
		
		Integer playerId =  record.getSelectedPlayerId().getPlayerId().getPlayerId();
		String matchTypeString = record.getSelectedPlayerId().getMatchId().getMatchTypeId().getMatchType();
		
		FieldingScore fieldingScore = fieldingScoreService.getRecordByPlayerIdMatchType(playerId,matchTypeString);
		
		if(fieldingScore==null) {
			fieldingScore = new FieldingScore();
			fieldingScore.setFieldingId(null);
			fieldingScore.setPlayerId(record.getSelectedPlayerId().getPlayerId());
			fieldingScore.setMatchTypeId(record.getSelectedPlayerId().getMatchId().getMatchTypeId());
			fieldingScore.setNumberOfCatch(record.getCatches());
		}else{
			fieldingScore.updateNumberOfCatch(record.getCatches());
		}
		
		FieldingScore updatedResult = fieldingScoreService.saveFieldingRecord(fieldingScore);
		
		if(updatedResult!=null) {
			return fieldingRecordRepository.save(record);				
		}else {
			return null;
		}
	}
	
	
	public FieldingRecord getFieldingRecordBtSelectedPlayerId(Integer selectedPlayerId) {
		return fieldingRecordRepository.getFieldingRecordBtSelectedPlayerId(selectedPlayerId);
	}


}
