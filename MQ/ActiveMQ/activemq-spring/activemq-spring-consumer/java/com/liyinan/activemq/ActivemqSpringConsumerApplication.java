package com.liyinan.activemq;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ActivemqSpringConsumerApplication {

    public static void main(String[] args) {

        new AnnotationConfigApplicationContext("com.liyinan.activemq");
    }
}
