package com.gopal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopal.producer.LibraryEventProducer;

@RestController
@RequestMapping("/api/library-events")
public class LibrayEventsController {
	
	private final LibraryEventProducer libraryEventProducer;

    @Autowired
    public LibrayEventsController(LibraryEventProducer libraryEventProducer) {
        this.libraryEventProducer = libraryEventProducer;
    }

    @PostMapping
    public ResponseEntity<String> postLibraryEvent(@RequestBody String libraryEvent) {
        // Logic to handle the incoming library event and send it to Kafka
        libraryEventProducer.sendLibraryEventMessage(libraryEvent);

        return ResponseEntity.status(HttpStatus.CREATED).body("Library event sent successfully");
    }

    @PutMapping
    public ResponseEntity<String> putLibraryEvent(@RequestBody String libraryEvent) {
        // Logic to handle the incoming library event and send it to Kafka
        libraryEventProducer.sendLibraryEventMessage(libraryEvent);

        return ResponseEntity.status(HttpStatus.OK).body("Library event updated successfully");
    }
}
