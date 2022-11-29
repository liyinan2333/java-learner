package com.liyinan.activemq.api.transaction;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueConsumer {

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_ID = "queue_transaction";

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        /**
         * 开启事务
         * 调用session.commit()的情况下，哪怕配成CLIENT_ACKNOWLEDGE，也无需手动ack
          */
        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_ID);
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(message -> {
            if (message != null && message instanceof TextMessage) {
                try {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println(">i> " + textMessage.getJMSDestination() + " " + textMessage.getJMSMessageID() + " context->" + textMessage.getText());
                    // commit后，该消息才会真正从队列中删除（可以接收多条消息后一起commit，表示同一个事务）
                    session.commit();
                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
