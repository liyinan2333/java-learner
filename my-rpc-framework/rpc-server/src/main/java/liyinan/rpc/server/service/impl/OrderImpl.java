package liyinan.rpc.server.service.impl;

import liyinan.rpc.service.OrderService;

/**
 * 要调用的具体的实现类
 *
 * @author liyinan2333
 * @date 2022/2/10
 */
public class OrderImpl implements OrderService {

    public OrderImpl() {
    }

    @Override
    public String buy() {
        System.out.println("buy方法被调用");
        return "调用buy方法成功";
    }
}