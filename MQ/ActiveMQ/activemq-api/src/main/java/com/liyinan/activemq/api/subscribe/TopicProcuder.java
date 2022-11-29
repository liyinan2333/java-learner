package com.liyinan.activemq.api.subscribe;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicProcuder {

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String TOPIC_ID = "topic_persistence";

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_ID);
        MessageProducer producer = session.createProducer(topic);
        // 设置消息持久化
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        // 设置好持久化之后再开启连接
        connection.start();
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
