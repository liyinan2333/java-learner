package com.liyinan.activemq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

public class JmsListener implements MessageListener {

    public static final Logger log = LoggerFactory.getLogger(JmsListener.class);

    @Override
    public void onMessage(Message message) {
        try {
            log.info(">i> {} {} context->{}", message.getJMSDestination(), message.getJMSMessageID(), message);
        } catch (JMSException e) {
            log.warn(e.getMessage(), e);
        }
    }
}
