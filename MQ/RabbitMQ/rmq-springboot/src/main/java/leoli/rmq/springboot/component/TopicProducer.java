package leoli.rmq.springboot.component;

import leoli.rmq.springboot.protocol.RMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * topic发送消息接口
 */
@Component
public class TopicProducer {

    @Autowired
    private RMQSender sender;

    public void send(String topic, String text) {
        this.sender.send(topic, text);
    }
}
