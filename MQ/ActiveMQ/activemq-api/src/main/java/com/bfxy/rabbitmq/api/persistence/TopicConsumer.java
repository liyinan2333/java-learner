package com.bfxy.rabbitmq.api.persistence;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicConsumer {

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String TOPIC_ID = "topic_persistence";

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("liyinan0001");
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_ID);
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "remark...");


    }
}
