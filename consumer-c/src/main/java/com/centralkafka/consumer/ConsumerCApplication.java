package com.centralkafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.centralkafka" })
public class ConsumerCApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerCApplication.class, args);
	}

}
