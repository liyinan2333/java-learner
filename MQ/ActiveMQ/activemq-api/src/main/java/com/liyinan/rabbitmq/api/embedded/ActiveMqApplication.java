package com.liyinan.rabbitmq.api.embedded;

import org.apache.activemq.broker.BrokerService;

import java.util.Scanner;

/**
 * Java内置的ActiveMQ服务端
 */
public class ActiveMqApplication {

    public static final String URL = "tcp://0.0.0.0:61616";

    public static void main(String[] args) throws Exception {

        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector(URL);

        brokerService.start();

        new Scanner(System.in).next();
    }

}
