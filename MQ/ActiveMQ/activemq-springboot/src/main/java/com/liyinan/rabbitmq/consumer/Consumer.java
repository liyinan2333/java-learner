package com.liyinan.rabbitmq.consumer;

import com.liyinan.rabbitmq.config.QueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Slf4j
@Component
public class Consumer {
    @JmsListener(destination = QueueConfig.QUEUE_ID)
    public void consumeQueue(Message message) throws JMSException {
        log.info(">i> {} {} context->{}", message.getJMSDestination(), message.getJMSMessageID(), message);
    }

    @JmsListener(destination = QueueConfig.TOPIC_ID)
    public void consumeTopic(Message message) throws JMSException {
        log.info(">i> {} {} context->{}", message.getJMSDestination(), message.getJMSMessageID(), message);
    }

}
