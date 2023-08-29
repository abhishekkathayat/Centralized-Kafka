package com.centralkafka.kafkautils.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaConsumerConfig<T> {
	
	@Autowired
	private KafkaConfig kafkaConfig;
	
	@Bean
	public ConsumerFactory<String, T> consumerFactory() {
		Map<String, Object> properties = new HashMap<>();
		
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getBootstrapServers());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConfig.getKafkaConsumerGroupId());
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		properties.put(JsonDeserializer.VALUE_DEFAULT_TYPE, kafkaConfig.getDtoClassName());
		
		return new DefaultKafkaConsumerFactory<>(properties);		
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, T> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, T> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
		
		return concurrentKafkaListenerContainerFactory;
	}
}
