package leoli.rmq.springboot.component;

import leoli.rmq.springboot.util.ProtocolLoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Fanout C端
 *
 * @author leoli
 * @date 2020/4/14
 */
@Component
public class FanoutConsumer {

    private final static Logger LOGGER = LoggerFactory.getLogger(FanoutConsumer.class);

    private String topicA = "spring.fanout.A";
    private String topicB = "spring.fanout.B";
    private String topicC = "spring.fanout.C";

    @RabbitListener(queues = "spring.fanout.A")
    public void processA(String text) {
        LOGGER.info(ProtocolLoggerUtil.asReceiveLog(topicA, text));
    }

    @RabbitListener(queues = "spring.fanout.B")
    public void processB(String text) {
        LOGGER.info(ProtocolLoggerUtil.asReceiveLog(topicB, text));
    }

    @RabbitListener(queues = "spring.fanout.C")
    public void processC(String text) {
        LOGGER.info(ProtocolLoggerUtil.asReceiveLog(topicC, text));
    }

}
