package com.liyinan.rabbitmq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class DestinationConfig {

    public static final String QUEUE_ID = "queue_spring_boot";
    public static final String TOPIC_ID = "topic_spring_boot";

    @Bean(QUEUE_ID)
    public Queue queueBean() {
        return new ActiveMQQueue(QUEUE_ID);
    }

    @Bean(TOPIC_ID)
    public Topic topicBean() {
        return new ActiveMQTopic(TOPIC_ID);
    }

}
