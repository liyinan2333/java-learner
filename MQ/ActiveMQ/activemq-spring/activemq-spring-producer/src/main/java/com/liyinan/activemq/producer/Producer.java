package com.liyinan.activemq.producer;

import com.liyinan.activemq.config.DestinationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class Producer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);
    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier(DestinationConfig.QUEUE_ID)
    Queue queue;
    @Autowired
    @Qualifier(DestinationConfig.TOPIC_ID)
    Topic topic;
    public void sendToQueue(String message) {
        log.info("<o< {} context->{}", queue, message);
        jmsTemplate.convertAndSend(queue, message);
    }
    public void sendToTopic(String message) {
        log.info("<o< {} context->{}", topic, message);
        jmsTemplate.convertAndSend(topic, message);
    }

}
