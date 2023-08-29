package com.centralkafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.centralkafka" })
public class ConsumerAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerAApplication.class, args);
	}
}
