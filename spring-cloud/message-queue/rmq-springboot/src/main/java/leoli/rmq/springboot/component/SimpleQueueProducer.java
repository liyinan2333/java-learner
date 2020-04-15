package leoli.rmq.springboot.component;

import leoli.rmq.springboot.bean.User;
import leoli.rmq.springboot.protocol.RMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * P端，测试接口
 * @author leoli
 * @date 2020/4/13
 */
@Component
public class SimpleQueueProducer {

    @Autowired
    private RMQSender sender;

    /**
     * 发送字符串
     * @param queueName 队列名
     * @param text 报文
     */
    public void send(String queueName, String text) {
        this.sender.send(queueName, text);
    }

    /**
     * 发送对象
     * @param queueName 队列名
     * @param user {@link User}对象，需实现{@link java.io.Serializable}接口
     */
    public void send(String queueName, User user) {
        this.sender.send(queueName, user);
    }

}
