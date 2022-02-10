package liyinan.rpc.client;

import liyinan.rpc.client.connection.ClientNetty;
import liyinan.rpc.client.proxy.ProxyFactory;
import liyinan.rpc.service.OrderService;

public class Client {

    public static void main(String[] args) throws InterruptedException {

        // 与server建立连接
         ClientNetty.connect("127.0.0.1", 8989);

        //创建一个代理对象给进行远程调用的类
        OrderService orderService = (OrderService) ProxyFactory.getProxy(new Class[]{OrderService.class});

        String result = orderService.buy();

        System.out.println(result);
    }
}