package com.centralkafka.consumer.service;

import org.springframework.stereotype.Service;

import com.centralkafka.kafkautils.config.KafkaConfig;
import com.centralkafka.kafkautils.constants.Constants;
import com.centralkafka.kafkautils.dto.ConsumerBDTO;
import com.centralkafka.kafkautils.dto.ConsumerCDTO;
import com.centralkafka.kafkautils.service.KafkaConsumer;
import com.centralkafka.kafkautils.service.KafkaProducer;

@Service
public class KafkaConsumerB extends KafkaConsumer<ConsumerBDTO> {
	
	private KafkaConfig kafkaConfig;
	
	private KafkaProducer<ConsumerCDTO> kafkaProducer;
	
	public KafkaConsumerB(KafkaConfig kafkaConfig, KafkaProducer<ConsumerCDTO> kafkaProducer) {
		super(kafkaConfig);
		this.kafkaConfig = kafkaConfig;
		this.kafkaProducer = kafkaProducer;
	}
	
	public void handleOperation(ConsumerBDTO consumerBDTO) {
		ConsumerCDTO consumerCDTO = new ConsumerCDTO();
		consumerCDTO.setConsumerCId((int) (Math.random() * 100));
		consumerCDTO.setConsumerCName(Constants.CONSUMER_C);
		consumerCDTO.setMessage(consumerBDTO.getMessage());
		consumerCDTO.setLastProcessedBy(consumerBDTO.getConsumerBName());
		
		kafkaProducer.publish(kafkaConfig.getKafkaProducerTopicName(), consumerCDTO);
	}
}
