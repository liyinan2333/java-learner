package leoli.rmq.springboot.conf;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ队列配置
 * @author leoli
 * @date 2020/4/13
 */
@Configuration
public class SimpleQueueConfig {

    /**
     * 创建队列
     * @return
     */
    @Bean
    public Queue SpringDefaultQueue() {
        return new Queue("spring.queue");
    }

}
