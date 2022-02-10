package liyinan.rpc.client.proxy;

import java.lang.reflect.Proxy;

/**
 * @author liyinan2333
 * @date 2022/2/10
 */
public class ProxyFactory {

    public static Object getProxy(Class<?>[] interfaces){

        return Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(),
                interfaces,
                new RPCInvocationHandler());
    }
}