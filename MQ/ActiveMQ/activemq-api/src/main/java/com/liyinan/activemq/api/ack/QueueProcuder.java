package com.liyinan.activemq.api.ack;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueProcuder {

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_ID = "queue_ack";

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // ack机制在c端设置
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_ID);
        MessageProducer producer = session.createProducer(queue);
        // 设置消息持久化（默认就是持久化的）
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for (int i = 1; i <= 3; i++) {
            TextMessage textMessage = session.createTextMessage("Hello ActiveMQ " + i);
            producer.send(textMessage);
            System.out.println("<o< " + textMessage.getJMSDestination() + " " + textMessage.getJMSMessageID() + " context->" + textMessage.getText());
        }

        producer.close();
        session.close();
        connection.close();
    }
}
