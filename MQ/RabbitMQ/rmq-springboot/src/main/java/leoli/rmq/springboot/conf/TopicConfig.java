package leoli.rmq.springboot.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ Topic配置
 * 注意：
 * 利用Binding关系将Exchange、Routing Key、Queue形成对应关系
 * 此处Routing Key为Topic
 *
 * @author liyinan
 * @date 2020/4/13
 */
@Configuration
public class TopicConfig {

    /**
     * 交换器
     */
    private final static String EXCHANGE_SPRING = "spring.topic";
    /**
     * topic
     */
    private final static String TOPIC_QUEUE_A = "spring.topic.queue.a";
    private final static String TOPIC_QUEUE_ALL = "spring.topic.queue.all";

    /**
     * topic/routingKey
     */
    private final static String TOPIC_A = "topic.a";
    private final static String TOPIC_ALL = "topic.#";

    /**
     * 创建队列
     *
     * @return 方法同名队列Bean
     */
    @Bean
    public Queue queueA() {
        return new Queue(TOPIC_QUEUE_A);
    }

    @Bean
    public Queue queueAll() {
        return new Queue(TOPIC_QUEUE_ALL);
    }

    /**
     * 创建topic交换器
     *
     * @return 方法同名交换器Bean
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_SPRING);
    }

    /**
     * 将队列绑定到Topic交换器，匹配单个topic
     *
     * @param queueA   同名队列{@link Bean}
     * @param exchange 交换器
     * @return
     */
    @Bean
    public Binding bindingExchangeMessage(Queue queueA, TopicExchange exchange) {
        return BindingBuilder.bind(queueA).to(exchange).with(TOPIC_A);
    }

    /**
     * 将队列绑定到Topic交换器，采用#的方式
     * (#匹配0个或多个单词，*匹配一个单词)
     * 注意：
     * 这里将queueMessages这个队列绑定到了 spring.#这个topic和 springExchange这个交换器,
     * 订阅时指定订阅queueMessages这个队列即可。
     *
     * @param queueAll 同名队列{@link Bean}
     * @param exchange 交换器
     * @return 绑定关系
     */
    @Bean
    public Binding bindingExchangeMessages(Queue queueAll, TopicExchange exchange) {
        return BindingBuilder.bind(queueAll).to(exchange).with(TOPIC_ALL);
    }
}
