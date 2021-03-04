package leoli.rmq.springboot.util;

import java.text.MessageFormat;

/**
 * 封装amqp日志规范
 *
 * @author leoli
 * @date 2020/4/14
 */
public class ProtocolLoggerUtil {

    /**
     * queue 发送日志
     *
     * @param queue
     * @param msg   报文
     * @return 组装好的日志文本
     */
    public static String asSendLog(String queue, String msg) {
        return MessageFormat.format("Sended [queue={0}] -> {1}", queue, msg);
    }

    /**
     * 组装接收日志
     *
     * @param queue 队列名
     * @param msg   报文
     * @return 组装好的日志文本
     */
    public static String asReceiveLog(String queue, String msg) {
        return MessageFormat.format("Received [queue={0}] <- {1}", queue, msg);
    }

    /**
     * fanout发送日志
     *
     * @param exchange 交换器
     * @param msg      报文
     * @return 组装好的日志文本
     */
    public static String asFanoutSendLog(String exchange, String msg) {
        return MessageFormat.format("Sended [exchange={0}] -> {1}", exchange, msg);
    }
}
