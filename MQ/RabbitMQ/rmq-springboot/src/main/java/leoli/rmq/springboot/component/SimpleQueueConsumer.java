package leoli.rmq.springboot.component;

import leoli.rmq.springboot.bean.User;
import leoli.rmq.springboot.util.ProtocolLoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * C端
 *
 * @author liyinan
 * @date 2020/4/13
 */
// 监听指定队列：spring
@Component
@RabbitListener(queues = "spring.queue")
public class SimpleQueueConsumer {

    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleQueueConsumer.class);

    private String queueName = "spring.queue";

    @RabbitHandler
    public void processText(String context) {
        LOGGER.info(ProtocolLoggerUtil.asReceiveLog(queueName, context));
    }

    @RabbitHandler
    public void processObject(User user) {
        LOGGER.info(ProtocolLoggerUtil.asReceiveLog(queueName, user.toString()));
    }
}
