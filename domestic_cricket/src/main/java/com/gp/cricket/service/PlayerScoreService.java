package com.gp.cricket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gp.cricket.mapobject.PlayerRate;

@Service
public class PlayerScoreService {
	
	public List<PlayerRate> getPlayerRateList(Integer clubId, Integer playerType, Integer order){
		if(clubId!=null && playerType!=null && order!=null) {
			if(order==0) {//ODI
				//1.First get ODI rating 
				//2.Then get T20 rating 
				//3.Finally Test
			}else if(order==1) {//T20
				
			}else if(order==2){//Test
				
			}
			
			//If club Player data not inserted 
		}
		
		return null;
	}
}
