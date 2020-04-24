package leoli.rmq.springboot.util;

import java.text.MessageFormat;

/**
 * 封装amqp日志规范
 * @author leoli
 * @date 2020/4/14
 */
public class ProtocolLoggerUtil {

    /**
     * topic|queue 发送日志
     * @param topic topic或者queue
     * @param msg 报文
     * @return 组装好的日志文本
     */
    public static String asSendLog(String topic, String msg) {
        return MessageFormat.format("Sended [topic|queue={0}] -> {1}", topic, msg);
    }

    /**
     * fanout发送日志
     * @param exchange 交换器
     * @param msg 报文
     * @return 组装好的日志文本
     */
    public static String asFanoutSendLog(String exchange, String msg) {
        return MessageFormat.format("Sended [exchange={0}] -> {1}", exchange, msg);
    }

    /**
     * 组装接收日志
     * @param topic 队列名或topic
     * @param msg 报文
     * @return 组装好的日志文本
     */
    public static String asReceiveLog(String topic, String msg) {
        return MessageFormat.format("Received [topic={0}] <- {1}", topic, msg);
    }
}
