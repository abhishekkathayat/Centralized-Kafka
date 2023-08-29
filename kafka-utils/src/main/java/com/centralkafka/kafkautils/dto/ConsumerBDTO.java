package com.centralkafka.kafkautils.dto;

import lombok.Data;

@Data
public class ConsumerBDTO {
	
	private Integer consumerBId;
	private String consumerBName;
	private String message;
	private String lastProcessedBy;
}
