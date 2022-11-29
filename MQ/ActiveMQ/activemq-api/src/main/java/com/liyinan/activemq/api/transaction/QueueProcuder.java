package com.liyinan.activemq.api.transaction;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueProcuder {

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_ID = "queue_transaction";

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 开启事务
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_ID);
        MessageProducer producer = session.createProducer(queue);
        // 设置消息持久化（默认就是持久化的）
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for (int i = 1; i <= 3; i++) {
            TextMessage textMessage = session.createTextMessage("Hello ActiveMQ " + i);
            producer.send(textMessage);
            System.out.println("<o< " + textMessage.getJMSDestination() + " " + textMessage.getJMSMessageID() + " context->" + textMessage.getText());
        }
        // 提交事务，才会真正的将消息放入队列
        session.commit();
        producer.close();
        session.close();
        connection.close();
    }
}
