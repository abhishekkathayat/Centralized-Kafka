package com.centralkafka.kafkautils.dto;

import lombok.Data;

@Data
public class ConsumerADTO {
	
	private Integer consumerAId;
	private String consumerAName;
	private String message;
	private String lastProcessedBy;
}
