package com.gopal.service;

import org.springframework.stereotype.Service;

import com.gopal.entity.FailureRecord;
import com.gopal.jpa.FailureRecordRepository;

@Service
public class FailureService {
	
	private final FailureRecordRepository failureRecordRepository;

	
	
	public FailureService(FailureRecordRepository failureRecordRepository) {
		super();
		this.failureRecordRepository = failureRecordRepository;
	}
	
	public String processFailureRecord(String errorMessage) {
		
		try {
			
			FailureRecord failureRecord = new FailureRecord();
			failureRecordRepository.save(failureRecord);
			return "Failure record proceessed successfully";
			
			}catch(Exception e) {
				
				return "Error processing failure record" + e.getMessage();
			}
		
	 }

	
	public FailureRecord getFailureRecordById(Long failureId) {
		
		
		
	   return failureRecordRepository.findById(failureId).orElse(null);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
