package com.centralkafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centralkafka.kafkautils.config.KafkaConfig;
import com.centralkafka.kafkautils.constants.Constants;
import com.centralkafka.kafkautils.dto.ConsumerADTO;
import com.centralkafka.kafkautils.service.KafkaProducer;

@RestController
@RequestMapping("/producer")
public class ProducerController {
	
	@Autowired
	private KafkaConfig kafkaConfig;
	
	@Autowired
	private KafkaProducer<ConsumerADTO> kafkaProducer;
	
	@GetMapping("/initiate")
	public String initiateProcess() {
		
		ConsumerADTO consumerADTO = new ConsumerADTO();
		consumerADTO.setConsumerAId((int) (Math.random() * 100));
		consumerADTO.setConsumerAName(Constants.CONSUMER_A);
		consumerADTO.setMessage(
				"Hello World! This is a Demonstration for Common Kafka Configurations, Consumer & Producer.");
		consumerADTO.setLastProcessedBy(Constants.PRODUCER);
		
		kafkaProducer.publish(kafkaConfig.getKafkaProducerTopicName(), consumerADTO);
		
		return "Successfully Initiated Process with Message: [" + consumerADTO.getMessage() + "]";
	}
}
