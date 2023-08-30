package com.centralkafka.kafkautils.service;

import org.springframework.kafka.annotation.KafkaListener;

import com.centralkafka.kafkautils.config.KafkaConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class KafkaConsumer<T> {
	
	private KafkaConfig kafkaConfig;
	
	public KafkaConsumer(KafkaConfig kafkaConfig) {
		this.kafkaConfig = kafkaConfig;
	}
	
	@KafkaListener(topics = "#{__listener.kafkaConsumerTopicName()}")
	public void consume(T data) {
		log.info("Message: {} consumed from Topic: {}", data, kafkaConsumerTopicName());
		handleOperation(data);
	}
	
	public String kafkaConsumerTopicName() {
		return kafkaConfig.getKafkaConsumerTopicName();
	}
	
	public abstract void handleOperation(T data);
}
