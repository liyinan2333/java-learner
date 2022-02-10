package liyinan.rpc.client.proxy;

import io.netty.channel.Channel;
import liyinan.rpc.client.connection.ClientNetty;
import liyinan.rpc.core.entity.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liyinan2333
 * @date 2022/2/10
 */
public class RPCInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        RpcRequest rpcRequest = new RpcRequest();

        rpcRequest.setArgs(args);
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParamType(method.getParameterTypes());
        rpcRequest.setClassName(method.getDeclaringClass().getSimpleName());

        ClientNetty.channel.writeAndFlush(rpcRequest);
        //一个阻塞操作，等待网络传输的结果
        String result = (String) ClientNetty.future.get();

        return result;
    }
}