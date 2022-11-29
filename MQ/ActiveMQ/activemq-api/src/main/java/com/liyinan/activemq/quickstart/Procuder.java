package com.liyinan.activemq.quickstart;

import cn.hutool.json.JSONUtil;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

public class Procuder {

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_ID = "queue_quickstart";
    private static final String TOPIC_ID = "topic_quickstart";

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        Queue queue = session.createQueue(QUEUE_ID);
//        MessageProducer producer = session.createProducer(queue);
        Topic topic = session.createTopic(TOPIC_ID);
        MessageProducer producer = session.createProducer(topic);
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
