package leoli.rmq.springboot;

import leoli.rmq.springboot.component.TopicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试topic
 * @author leoli
 * @date 2020/4/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {

    @Autowired
    private TopicProducer producer;

    @Test
    public void sendText() {
        producer.send("spring.topic.A", "TOPIC_MESSAGE_A");
        producer.send( "spring.topic.B", "TOPIC_MESSAGE_B");
    }

}
