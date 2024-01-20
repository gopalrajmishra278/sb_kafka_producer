package com.gopal.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LibraryEventProducer {

	 private final KafkaTemplate<String, String> kafkaTemplate;
	 private final ObjectMapper objectMapper;
	 
	 private Logger logger = LoggerFactory.getLogger(LibraryEventProducer.class);

	    @Value("${spring.kafka.topic.library-events}")
	    private String libraryEventsTopic;

	    @Autowired
	    public LibraryEventProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
	        this.kafkaTemplate = kafkaTemplate;
	        this.objectMapper = objectMapper;
	    }

	    public void sendLibraryEventMessage(String message) {
	        try {
	            String key = generateKey(); // You can customize the key generation logic
	            String value = objectMapper.writeValueAsString(message);

	            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(libraryEventsTopic, key, value);

	            // Send the message to the Kafka topic
	            kafkaTemplate.send(producerRecord);
	            this.logger.info("Producer record send");
	        } catch (JsonProcessingException e) {
	            // Handle JSON processing exception
	            e.printStackTrace();
	        }
	    }

	    private String generateKey() {
	        // Custom logic for generating a message key (you can use a library like UUID)
	        return String.valueOf(System.currentTimeMillis());
	    }
	}
