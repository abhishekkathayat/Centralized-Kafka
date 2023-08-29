package com.centralkafka.kafkautils.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class KafkaConfig {
	
	@Value(value = "${spring.kafka.consumer.dto:default}")
	private String dtoClassName;
	
	@Value(value = "${spring.kafka.consumer.topic:default}")
	private String kafkaConsumerTopicName;
	
	@Value(value = "${spring.kafka.consumer.group-id:default}")
	private String kafkaConsumerGroupId;
	
	@Value(value = "${spring.kafka.bootstrap-servers:default")
	private String bootstrapServers;
	
	@Value(value = "${spring.kafka.template.default-topic:default}")
	private String kafkaProducerTopicName;
}
