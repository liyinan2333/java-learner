package leoli.rmq.springboot.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fanout模式配置
 * 注意：
 * Fanout交换器没有Routing Key的概念， 交换器会把收到的消息广播到每一个队列
 *
 * @author leoli
 * @date 2020/4/14
 */
@Configuration
public class FanoutConfig {
    @Bean
    public Queue fanoutQueueA() {
        return new Queue("spring.fanout.A");
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue("spring.fanout.B");
    }

    @Bean
    public Queue fanoutQueueC() {
        return new Queue("spring.fanout.C");
    }

    /**
     * 创建Fanout交换器(广播)
     *
     * @return
     */
    @Bean
    FanoutExchange springFanoutExchange() {
        return new FanoutExchange("spring.fanout");
    }

    /**
     * 将队列绑定到Fanout交换器
     * 此处将三个队列均绑定到springFanoutExchange
     *
     * @param fanoutQueueA         同名队列({@link Bean})
     * @param springFanoutExchange 同名交换器({@link Bean})
     * @return 绑定关系
     */
    @Bean
    Binding bindingExchangeA(Queue fanoutQueueA, FanoutExchange springFanoutExchange) {
        return BindingBuilder.bind(fanoutQueueA).to(springFanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue fanoutQueueB, FanoutExchange springFanoutExchange) {
        return BindingBuilder.bind(fanoutQueueB).to(springFanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue fanoutQueueC, FanoutExchange springFanoutExchange) {
        return BindingBuilder.bind(fanoutQueueC).to(springFanoutExchange);
    }

}
