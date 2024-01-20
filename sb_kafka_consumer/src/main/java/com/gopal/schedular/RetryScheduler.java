package com.gopal.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gopal.service.LibraryEventsService;

@Component
public class RetryScheduler {
	
	
	private final LibraryEventsService libraryEventsService;
    
	@Autowired
	public RetryScheduler(LibraryEventsService libraryEventsService) {
		super();
		this.libraryEventsService = libraryEventsService;
	}
	
	@Scheduled(cron="0 * 5 * * * ?")
	public void retryFailedLibraryEvents() {
		
		libraryEventsService.retryFailedLibraryEvents();
		
		
	}
	
}
