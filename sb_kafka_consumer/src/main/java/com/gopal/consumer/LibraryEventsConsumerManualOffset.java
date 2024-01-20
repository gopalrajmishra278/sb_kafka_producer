package com.gopal.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class LibraryEventsConsumerManualOffset {
	
	@KafkaListener(topics = "${spring.kafka.topic.library-events}")
    public void onMessage(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
        // Logic to process the consumed message
        System.out.println("Consumed message: " + consumerRecord.value());

        // Add your business logic here to handle the consumed message

        // Manually acknowledge the message offset to Kafka
        acknowledgment.acknowledge();
    }

}
