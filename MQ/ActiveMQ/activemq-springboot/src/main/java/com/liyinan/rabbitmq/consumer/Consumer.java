package com.liyinan.rabbitmq.consumer;

import com.liyinan.rabbitmq.config.DestinationConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Slf4j
@Component
public class Consumer {
    @JmsListener(destination = DestinationConfig.QUEUE_ID)
    public void consumeQueue(Message message) throws JMSException {
        log.info(">i> {} {} context->{}", message.getJMSDestination(), message.getJMSMessageID(), message);
    }

    @JmsListener(destination = DestinationConfig.TOPIC_ID)
    public void consumeTopic(Message message) throws JMSException {
        log.info(">i> {} {} context->{}", message.getJMSDestination(), message.getJMSMessageID(), message);
    }

}
