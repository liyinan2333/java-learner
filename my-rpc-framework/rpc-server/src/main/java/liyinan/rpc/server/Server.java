package liyinan.rpc.server;

import liyinan.rpc.server.connection.ServerNetty;
import liyinan.rpc.server.service.impl.OrderImpl;

import java.util.HashMap;

/**
 * @author liyinan2333
 * @date 2022/2/10
 */
public class Server {

    public static HashMap<String, Object> register = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        //开启netty网络服务
        ServerNetty.connect(8989);

        //服务注册
        register.put("OrderService", new OrderImpl());

    }
}