package com.gp.cricket.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.cricket.entity.Club;
import com.gp.cricket.entity.ClubPayment;
import com.gp.cricket.repository.ClubPaymentRepository;
import com.gp.cricket.repository.ClubRepository;

@Service
public class ClubPaymentService {
	
	@Autowired
	ClubPaymentRepository clubPaymentRepository;
	
	@Autowired
	ClubRepository clubRepository;
	

	public Integer addClubPayment(ClubPayment clubPayment) {
	
		if(clubPaymentObjectValidated(clubPayment)) {
			
			//check whether already for this year or not
			ClubPayment object = clubPaymentRepository.findClubPaymentByClubIdAndYear(clubPayment.getClubId(), clubPayment.getPaymentForYear());		
			if(object==null) {
				
				Boolean isClubStatusChanged =false;
				
				//check club is deactivate.If deactivate if payment for currentYear then activate club
				Integer currentYear = getLocalCurrentYear();
				if(clubPayment.getPaymentForYear() == currentYear) {
					if(clubPayment.getClubId().getStatus()==0) {
						clubPayment.getClubId().setStatus((byte) 1);
						isClubStatusChanged = true;
					}
				}
				
				clubPaymentRepository.save(clubPayment);
				if(isClubStatusChanged) {
					return 2;//payment success and club activated
				}	
				return 1;//payment success
			}
			return 0;//Already pay payment
		}
		return null;
	}
	
	
	public List<ClubPayment> getClubpaymentData(Integer clubId){
		if(clubId!=null && clubRepository.existsById(clubId) ) {
			List<ClubPayment> clubPaymentList = new ArrayList<ClubPayment>();
			clubPaymentList =  clubPaymentRepository.findByClubId(clubRepository.findClubByClubId(clubId));
			return clubPaymentList;
		}
		return null;
	}
	
	
	
	public Boolean clubPaymentObjectValidated(ClubPayment object) {
		if(object!=null && object.getAmount()!=null && object.getDate()!=null && object.getPaymentForYear()!=null && object.getClubId()!=null && object.getDate()!=null) {
			if(object.getClubId().getClubId()!=null && object.getClubId().getClubId()>0 && clubRepository.existsById(object.getClubId().getClubId())) {
				return true;
			}
		}
		return false;
	}
	
	public Integer getLocalCurrentYear() {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Colombo"));
		Date currentDate = calendar.getTime();
		LocalDate today = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		return today.getYear();
	}
}
