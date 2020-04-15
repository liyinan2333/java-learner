package leoli.rmq.springboot.component;

import leoli.rmq.springboot.util.ProtocolLoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * topic接收消息接口
 * @author leoli
 * @date 2020/4/14
 */
@Component
public class TopicConsumer {

    private final static Logger LOGGER = LoggerFactory.getLogger(TopicConsumer.class);

    private String topic1 = "spring.";
    private String topic2 = "spring.topic2";

    // 订阅单个topic:spring.message
    @RabbitListener(queues = "spring.topic1")
    public void process1(String message) {
        LOGGER.info(ProtocolLoggerUtil.asReceiveLog(topic1, message));
    }

    // 由于该队列指向spring.#，所以订阅该队列相当于订阅spring.# topic
    @RabbitListener(queues = "spring.topic2")
    public void process2(String message) {
        LOGGER.info(ProtocolLoggerUtil.asReceiveLog(topic2, message));
    }
}
