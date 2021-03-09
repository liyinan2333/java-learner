package leoli.rmq.springboot;

import leoli.rmq.springboot.bean.User;
import leoli.rmq.springboot.component.SimpleQueueProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试简单队列
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class SimpleQueueTest {

    @Autowired
    private SimpleQueueProducer producer;

    // 发送单条text消息
    @Test
    public void sendText() {
        producer.send("spring.queue", "Hello, Leoli!");
    }

    // 发送单条object消息
    @Test
    public void sendObject() {
        producer.send("spring.queue", new User("Leoli", Short.valueOf("1"), 24));
    }
}