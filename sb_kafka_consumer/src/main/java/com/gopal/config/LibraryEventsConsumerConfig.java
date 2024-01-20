package com.gopal.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
public class LibraryEventsConsumerConfig {
    
	@Value("${spring.kafka.bootstrap-severs}")
	private String bootstrapServers;
	
	  
    @Value("${spring.kafka.group-id}")
	private String groupId;
    
    @Bean
    public ConsumerFactory<String, Object> consumerFactory(){
		
    	Map<String, Object> props = new HashMap<>();
    	props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
       	props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
       	props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		ErrorHandlingDeserializer<Object> errorHandlingDeserializer = new ErrorHandlingDeserializer<>(
                new JsonDeserializer<>(Object.class));
		
		return  new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>());
    	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
