package com.liyinan.activemq.config;

import com.liyinan.activemq.consumer.JmsListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

@Configuration
@Import(JmsConfig.class)
public class JmsListenerConfig {

    @Bean
    public JmsListener jmsListener() {
        return new JmsListener();
    }

    @Bean
    public MessageListenerContainer queueMessageListenerContainer(Destination queue_spring, JmsListener jmsListener, ConnectionFactory pooledConnectionFactory) {
        DefaultMessageListenerContainer messageListenerContainer = new DefaultMessageListenerContainer();
        messageListenerContainer.setDestination(queue_spring);
        messageListenerContainer.setupMessageListener(jmsListener);
        messageListenerContainer.setConnectionFactory(pooledConnectionFactory);
        return messageListenerContainer;
    }

    @Bean
    public MessageListenerContainer topicMessageListenerContainer(Destination topic_spring, JmsListener jmsListener, ConnectionFactory pooledConnectionFactory) {
        DefaultMessageListenerContainer messageListenerContainer = new DefaultMessageListenerContainer();
        messageListenerContainer.setDestination(topic_spring);
        messageListenerContainer.setupMessageListener(jmsListener);
        messageListenerContainer.setConnectionFactory(pooledConnectionFactory);
        return messageListenerContainer;
    }
}
