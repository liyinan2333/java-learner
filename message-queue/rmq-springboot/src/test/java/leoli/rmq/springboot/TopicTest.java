package leoli.rmq.springboot;

import leoli.rmq.springboot.component.TopicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试topic
 *
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
        // 直接向队列中塞消息
        producer.send("spring.topic.a", "TOPIC_MESSAGE_A");
        // 通过exchange和topic(routingKey)找到对应的队列，由于队列spring.topic.all绑定了topic.#，所有topic.开头的消息都会塞到spring.topic.all队列中
        producer.send("spring.topic", "topic.123", "TOPIC_MESSAGE_123");
    }

}
