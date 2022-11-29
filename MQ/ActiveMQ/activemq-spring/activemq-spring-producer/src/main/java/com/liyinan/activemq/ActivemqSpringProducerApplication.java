package com.liyinan.activemq;

import com.liyinan.activemq.producer.Producer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ActivemqSpringProducerApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.liyinan.activemq");
        Producer producer = context.getBean("producer", Producer.class);
        producer.sendToQueue("哈哈哈哈哈哈哈 Queue ~");
        producer.sendToTopic("哈哈哈哈哈哈哈 Topic ~");

    }
}
