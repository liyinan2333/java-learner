package com.liyinan.activemq.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ProducerTest {

    @Autowired
    Producer producer;

    @Test
    public void sendToQueue() {
        producer.sendToQueue("哈哈哈哈哈哈哈 Queue ~");
    }

    @Test
    public void sendToTopic() {
        producer.sendToTopic("哈哈哈哈哈哈哈 Topic ~");
    }
}