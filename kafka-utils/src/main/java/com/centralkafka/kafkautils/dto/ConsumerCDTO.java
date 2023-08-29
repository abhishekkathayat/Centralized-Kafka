package com.centralkafka.kafkautils.dto;

import lombok.Data;

@Data
public class ConsumerCDTO {
	
	private Integer consumerCId;
	private String consumerCName;
	private String message;
	private String lastProcessedBy;
}
