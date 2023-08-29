package com.centralkafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centralkafka.kafkautils.config.KafkaConfig;
import com.centralkafka.kafkautils.constants.Constants;
import com.centralkafka.kafkautils.dto.ConsumerBDTO;
import com.centralkafka.kafkautils.dto.ConsumerCDTO;
import com.centralkafka.kafkautils.service.KafkaConsumer;
import com.centralkafka.kafkautils.service.KafkaProducer;

@Service
public class KafkaConsumerB extends KafkaConsumer<ConsumerBDTO> {
	
	@Autowired
	private KafkaConfig kafkaConfig;
	
	@Autowired
	private KafkaProducer<ConsumerCDTO> kafkaProducer;
	
	public void handleOperation(ConsumerBDTO consumerBDTO) {
		ConsumerCDTO consumerCDTO = new ConsumerCDTO();
		consumerCDTO.setConsumerCId((int) (Math.random() * 100));
		consumerCDTO.setConsumerCName(Constants.CONSUMER_C);
		consumerCDTO.setMessage(consumerBDTO.getMessage());
		consumerCDTO.setLastProcessedBy(consumerBDTO.getConsumerBName());
		
		kafkaProducer.publish(kafkaConfig.getKafkaProducerTopicName(), consumerCDTO);
	}
}
