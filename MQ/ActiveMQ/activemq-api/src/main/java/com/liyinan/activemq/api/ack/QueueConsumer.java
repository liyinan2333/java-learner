package com.liyinan.activemq.api.ack;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueConsumer {

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_ID = "queue_ack";

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // AUTO_ACKNOWLEDGE: 自动ack; CLIENT_ACKNOWLEDGE: 手动ack
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_ID);
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(message -> {
            if (message != null && message instanceof TextMessage) {
                try {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println(">i> " + textMessage.getJMSDestination() + " " + textMessage.getJMSMessageID() + " context->" + textMessage.getText());
                    // 手动ack
                    textMessage.acknowledge();
                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
