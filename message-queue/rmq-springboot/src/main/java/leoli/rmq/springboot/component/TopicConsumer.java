package leoli.rmq.springboot.component;

import leoli.rmq.springboot.util.ProtocolLoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * topic接收消息接口
 *
 * @author leoli
 * @date 2020/4/14
 */
@Component
public class TopicConsumer {

    private final static Logger LOGGER = LoggerFactory.getLogger(TopicConsumer.class);

    private static final String queueA = "spring.topic.queue.a";
    private static final String queueB = "spring.topic.queue.all";

    // 订阅单个queue. spring.topic.a队列 对应 spring交换机->topic.a
    @RabbitListener(queues = {queueA})
    public void process1(String message) {
        LOGGER.info(ProtocolLoggerUtil.asReceiveLog(queueA, message));
    }

    // 由于该队列指向spring.#，所以订阅该队列相当于订阅spring.# topic
    @RabbitListener(queues = {queueB})
    public void process2(String message) {
        LOGGER.info(ProtocolLoggerUtil.asReceiveLog(queueB, message));
    }
}
