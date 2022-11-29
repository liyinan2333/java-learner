package com.liyinan.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.ConnectionFactory;

@Configuration
public class JmsConfig {

    public static final String BROKER_URL = "tcp://127.0.0.1:61616";
    public static final String DEFAULT_QUEUE_ID = "queue_spring_default";

    // ActiveMQ connnection factory.
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        return new ActiveMQConnectionFactory(BROKER_URL);
    }

    // ActiveMQ pooled connection factory.
    @Bean
    public PooledConnectionFactory pooledConnectionFactory(ActiveMQConnectionFactory connectionFactory) {
        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
        pooledConnectionFactory.setConnectionFactory(connectionFactory);
        return pooledConnectionFactory;
    }

    // Message converter.
    @Bean
    public MessageConverter messageConverter() {
        return new SimpleMessageConverter();
    }

    // JmsTemplate
    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory pooledConnectionFactory, MessageConverter messageConverter) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(pooledConnectionFactory);
        jmsTemplate.setMessageConverter(messageConverter);
        return jmsTemplate;
    }

}
