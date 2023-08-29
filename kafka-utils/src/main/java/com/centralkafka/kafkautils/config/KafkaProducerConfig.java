package com.centralkafka.kafkautils.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class KafkaProducerConfig<T> {
	
	@Autowired
	private KafkaConfig kafkaConfig;
	
	@Bean
	public ProducerFactory<String, T> producerFactory() {
		Map<String, Object> properties = new HashMap<>();
		
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getBootstrapServers());
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(properties);
	}
	
	@Bean
	public KafkaTemplate<String, T> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
}
