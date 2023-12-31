package com.centralkafka.consumer.service;

import org.springframework.stereotype.Service;

import com.centralkafka.kafkautils.config.KafkaConfig;
import com.centralkafka.kafkautils.constants.Constants;
import com.centralkafka.kafkautils.dto.ConsumerADTO;
import com.centralkafka.kafkautils.dto.ConsumerBDTO;
import com.centralkafka.kafkautils.service.KafkaConsumer;
import com.centralkafka.kafkautils.service.KafkaProducer;

@Service
public class KafkaConsumerA extends KafkaConsumer<ConsumerADTO> {
	
	private KafkaConfig kafkaConfig;
	
	private KafkaProducer<ConsumerBDTO> kafkaProducer;
	
	public KafkaConsumerA(KafkaConfig kafkaConfig, KafkaProducer<ConsumerBDTO> kafkaProducer) {
		super(kafkaConfig);
		this.kafkaConfig = kafkaConfig;
		this.kafkaProducer = kafkaProducer;
	}
	
	public void handleOperation(ConsumerADTO consumerADTO) {
		ConsumerBDTO consumerBDTO = new ConsumerBDTO();
		consumerBDTO.setConsumerBId((int) (Math.random() * 100));
		consumerBDTO.setConsumerBName(Constants.CONSUMER_B);
		consumerBDTO.setMessage(consumerADTO.getMessage());
		consumerBDTO.setLastProcessedBy(consumerADTO.getConsumerAName());
		
		kafkaProducer.publish(kafkaConfig.getKafkaProducerTopicName(), consumerBDTO);
	}
}
