package com.gopal.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Service;

@Service
public class LibraryEventsRetryConsumer {
	
	
	 private static final int MAX_RETRIES = 3;

	    @KafkaListener(topics = "${spring.kafka.topic.library-events}")
	    public void onMessage(ConsumerRecord<String, String> consumerRecord) throws Exception {
	        // Logic to process the consumed message
	        System.out.println("Consumed message: " + consumerRecord.value());

	        // Add your business logic here to handle the consumed message

	        // Simulate an exception for testing retry
	        throw new Exception("Simulated exception for retry");
	    }

	    @Recover
	    public void recover(Exception e, ConsumerRecord<String, String> consumerRecord) {
	        // Recover logic when retry attempts are exhausted
	        System.err.println("Retry attempts exhausted. Unable to process message: " + consumerRecord.value());
	    }
	
	}
