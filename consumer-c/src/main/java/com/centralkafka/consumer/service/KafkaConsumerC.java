package com.centralkafka.consumer.service;

import org.springframework.stereotype.Service;

import com.centralkafka.kafkautils.config.KafkaConfig;
import com.centralkafka.kafkautils.dto.ConsumerCDTO;
import com.centralkafka.kafkautils.service.KafkaConsumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumerC extends KafkaConsumer<ConsumerCDTO> {
	
	public KafkaConsumerC(KafkaConfig kafkaConfig) {
		super(kafkaConfig);
	}

	public void handleOperation(ConsumerCDTO consumerCDTO) {
		log.info("Recieved Message at Final Destination: [{}]", consumerCDTO);
	}
}
