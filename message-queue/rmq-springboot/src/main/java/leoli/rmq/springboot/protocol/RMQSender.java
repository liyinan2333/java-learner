package leoli.rmq.springboot.protocol;

import leoli.rmq.springboot.bean.User;
import leoli.rmq.springboot.component.SimpleQueueProducer;
import leoli.rmq.springboot.util.ProtocolLoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 统一的rmq消息出口
 *
 * @author leoli
 * @date 2020/4/14
 */
@Component
public class RMQSender {
    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleQueueProducer.class);

    @Autowired
    private AmqpTemplate template;

    /**
     * queue|topic发送文本
     * 注意：
     * 实际上是向队列发送消息，这里传入exchange(已配置化)和topic，用来通过绑定关系定位队列
     *
     * @param topic 队列名或topic
     * @param text  报文
     */
    public void send(String topic, String text) {
        this.template.convertAndSend(topic, text);
        LOGGER.info(ProtocolLoggerUtil.asSendLog(topic, text));
    }

    /**
     * queue|topic 发送对象
     *
     * @param topic topic
     * @param obj   要发送的对象，需实现{@link java.io.Serializable}接口
     */
    public void send(String topic, Object obj) {
        this.template.convertAndSend(topic, obj);
        LOGGER.info(ProtocolLoggerUtil.asSendLog(topic, obj.toString()));
    }

    /**
     * Topic|Fanout发送文本
     *
     * @param exchange 交换器
     * @param topic    队列名或topic,若使用Fanout，topic传""
     * @param text     报文
     */
    public void send(String exchange, String topic, String text) {
        this.template.convertAndSend(topic, text);
        LOGGER.info(ProtocolLoggerUtil.asSendLog(topic, text));
    }

}
