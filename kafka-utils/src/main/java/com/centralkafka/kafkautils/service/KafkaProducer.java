package com.centralkafka.kafkautils.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaProducer<T> {
	
	private KafkaTemplate<String, T> kafkaTemplate;
	
	public KafkaProducer(KafkaTemplate<String, T> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void publish(String kafkaTopic, T data) {
		kafkaTemplate.send(kafkaTopic, data)
			.whenComplete((result, exception) -> {
				if(exception == null) {
					log.info("Message Published to Topic: {} and Partition: {} with Offset: {}",
							kafkaTopic, result.getRecordMetadata().partition(), result.getRecordMetadata().offset());
				}
				else {
					log.error("Message publish failed with error: {}", exception.getMessage());
				}
			});
	}
}
