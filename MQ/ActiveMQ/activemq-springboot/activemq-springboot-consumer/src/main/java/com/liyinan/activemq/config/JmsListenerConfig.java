package com.liyinan.activemq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import java.util.concurrent.Executors;

@Configuration
public class JmsListenerConfig {

    /**
     * 注入监听Queue消息的监听器工厂
     * 除了这里，还需要在@JmsListener注解中指定要使用的ContainerFactory
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory jmsQueueListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setPubSubDomain(false);
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        // 配置消息异步处理
        jmsListenerContainerFactory.setTaskExecutor(Executors.newFixedThreadPool(8));
        jmsListenerContainerFactory.setConcurrency("8");
        return jmsListenerContainerFactory;
    }

    /**
     * 注入监听Topic消息的监听器工厂
     * 除了这里，还需要在@JmsListener注解中指定要使用的ContainerFactory
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setPubSubDomain(true);
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        return jmsListenerContainerFactory;
    }

}
