package com.liyinan.activemq.producer;

import com.liyinan.activemq.config.DestinationConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@Slf4j
@RestController
@RequestMapping("send")
public class Producer {

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    @Qualifier(DestinationConfig.QUEUE_ID)
    Queue queue;

    @Autowired
    @Qualifier(DestinationConfig.TOPIC_ID)
    Topic topic;

    @RequestMapping("queue")
    public ResponseEntity sendToQueue(@RequestParam("message") String message) {
        log.info("<o< {} context->{}", queue, message);
        jmsMessagingTemplate.convertAndSend(queue, message);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("topic")
    public ResponseEntity sendToTopic(@RequestParam("message") String message) {
        log.info("<o< {} context->{}", topic, message);
        jmsMessagingTemplate.convertAndSend(topic, message);
        return ResponseEntity.ok().build();
    }

    @Scheduled(fixedDelay = 3000)
    public void scheduledSendMessage() {
        this.sendToQueue("红红火火恍恍惚惚 Queue ~");
        this.sendToTopic("红红火火恍恍惚惚 Topic ~");
    }

}
