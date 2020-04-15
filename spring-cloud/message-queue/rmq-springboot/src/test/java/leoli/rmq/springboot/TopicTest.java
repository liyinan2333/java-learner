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
        producer.send("spring.topic1", "TOPIC_MESSAGE_1");
        producer.send( "spring.topic2", "TOPIC_MESSAGE_2");
    }

}
