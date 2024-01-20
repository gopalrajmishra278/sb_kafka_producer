package com.gopal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gopal.entity.LibraryEvent;
import com.gopal.jpa.LibraryEventRepository;

@Service
public class LibraryEventsService {

	   private final LibraryEventRepository libraryEventsRepository;

	    @Autowired
	    public LibraryEventsService(LibraryEventRepository libraryEventsRepository) {
	        this.libraryEventsRepository = libraryEventsRepository;
	    }
        
	    @Transactional
	    public String processLibraryEvent(LibraryEvent libraryEvent) {
	        // Custom logic for processing successful events
	        libraryEventsRepository.save(libraryEvent);
	        return "Library event processed successfully";
	    }

	    // Add more methods as needed for your specific use case

	    public LibraryEvent getLibraryEventById(Long eventId) {
	        return libraryEventsRepository.findById(eventId).orElse(null);
	    }

	    @Transactional
	    public void retryFailedLibraryEvents() {
	        // Retrieve failed library events from the database (customize the query as needed)
	        List<LibraryEvent> failedLibraryEvents = libraryEventsRepository.findFailedLibraryEvents();

	        // Retry each failed library event
	        for (LibraryEvent libraryEvent : failedLibraryEvents) {
	            try {
	                // Retry logic (e.g., reprocess the event)
	                // Update the event status after successful retry
	                libraryEvent.setRetryStatus("RETRIED");
	                libraryEventsRepository.save(libraryEvent);
	            } catch (Exception e) {
	                // Handle the exception or log the error
	                // You may choose to retry the event again in the next scheduled run
	            }
	        }
	    }
}
