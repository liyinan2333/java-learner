package liyinan.rpc.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import liyinan.rpc.core.entity.RpcRequest;
import liyinan.rpc.core.entity.RpcResponse;
import liyinan.rpc.server.Server;

import java.lang.reflect.Method;

/**
 * 服务端接收到请求->调用方法->返回响应
 *
 * @author liyinan2333
 * @date 2022/2/10
 */
public class ServerHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext context, Object message) throws Exception {

        // 获取使用反射需要的各个参数
        RpcRequest request = (RpcRequest) message;
        String methodName = request.getMethodName();
        Class[] paramTypes = request.getParamType();
        Object[] args = request.getArgs();
        String className = request.getClassName();

        //从注册中心容器中获取对象
        Object service = Server.register.get(className);
        //反射调用方法
        Method method = service.getClass().getMethod(methodName, paramTypes);
        String result = (String) method.invoke(service, args);

        // 将响应结果封装好后发送回去
        RpcResponse rpcResponse = new RpcResponse();
        rpcResponse.setCode(200);
        rpcResponse.setResult(result);

        context.writeAndFlush(rpcResponse);
    }
}