package leoli.rmq.springboot.component;

import leoli.rmq.springboot.protocol.RMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Fanout P端
 * @author leoli
 * @date 2020/4/14
 */
@Component
public class FanoutProducer {

    @Autowired
    private RMQSender sender;

    public void send(String exchange, String text) {
        this.sender.send(exchange, "", text);
    }
}
