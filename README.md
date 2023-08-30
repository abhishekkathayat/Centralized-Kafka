# Centralized Kafka
A Centralized Kafka Utility `kafka-utils` designed to streamline Kafka related configurations, consumer and producer logic across multiple microservices. By abstracting away direct Kafka usage in microservices, this utility promotes code reusability and maintainability.

### Key Features
- Define all Kafka configurations, consumer and producer logic in one place for all microservices.
- Shifts focus on building the business logic without directly dealing with Kafka related configurations.
- Promotes consistency of Kafka configurations across all microservices and makes it easy to modify Kafka behavior globally without altering individual microservices.
- Reduces boilerplate code across microservices thus promoting code reusability.

### Prerequisites
Before getting started please make sure of the following:
- You have Spring Tool Suite/Intellij Idea + JDK setup in local.
- You have Kafka setup in local.
- Topics are configured. We're using `consumer_a`, `consumer_b`, `consumer_c` as the topics for demonstration.

Refer to the Official Documentation to get started on Apache Kafka - [Apache Kafka Quickstart Guide](https://kafka.apache.org/quickstart)

### Getting Started
Follow the below mentioned steps to get started:

- Add `kafka-utils` as a dependency to you Spring Boot project.
- Configure Kafka properties in your application.properties.
- Extend utility class `KafkaConsumer` to implement the Consumer Functionality.
- Provide the implementation for the abstract function `handleOperation(data)`. This function server as the designated space where you can define the business logic that needs to be executed upon consuming a message.
- Inject `KafkaProducer` dependency by using either Field Injection/Autowiring or Constructor Injection, and call the `publish(topic, data)` function to publish a message.

You can also refer to `producer`, `consumer-a`, `consumer-b` and `consumer-c` services to get started. When using these services for testing, once all the services are up and running call the below mentioned endpoint using Postman or Browser:
```
http://localhost:8080/producer/initiate
```

<br/> That's it! Thanks for dropping by.
