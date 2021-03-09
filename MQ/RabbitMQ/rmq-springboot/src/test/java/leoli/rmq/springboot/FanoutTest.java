package leoli.rmq.springboot;

import leoli.rmq.springboot.component.FanoutProducer;
import leoli.rmq.springboot.component.TopicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试fanout
 * @author leoli
 * @date 2020/4/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutTest {

    @Autowired
    private FanoutProducer producer;

    @Test
    public void sendText() throws InterruptedException {
        producer.send("spring.fanout", "This is a FANOUT message from spring.fanout!");
        Thread.sleep(10*1000);
    }

}
