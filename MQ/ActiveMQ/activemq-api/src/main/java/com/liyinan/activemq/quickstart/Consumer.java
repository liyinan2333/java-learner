package com.liyinan.activemq.quickstart;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

public class Consumer {

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_ID = "queue_quickstart";
    private static final String TOPIC_ID = "topic_quickstart";

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        Queue queue = session.createQueue(QUEUE_ID);
//        MessageConsumer consumer = session.createConsumer(queue);
        Topic topic = session.createTopic(TOPIC_ID);
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(msg -> {
            if (msg != null && msg instanceof TextMessage) {
                try {
                    TextMessage textMessage = (TextMessage) msg;
                    System.out.println(">i> " + textMessage.getJMSDestination() + " " + textMessage.getJMSMessageID() + " context->" + textMessage.getText());
                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }
            }
        });
//		consumer.receive(1000);
//        while (true) {
//            Message message = consumer.receive();
//            if (message != null && message instanceof ActiveMQTextMessage) {
//                ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
//                System.out.println(">i> " + textMessage);
//            }
//        }

//		consumer.close();
//		session.close();
//		connection.close();
    }
}
