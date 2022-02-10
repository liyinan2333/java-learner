package liyinan.rpc.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import liyinan.rpc.client.connection.ClientNetty;
import liyinan.rpc.core.entity.RpcResponse;

/**
 * @author liyinan2333
 * @date 2022/2/10
 */
public class ClientHandler extends SimpleChannelInboundHandler {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        RpcResponse rpcResponse = (RpcResponse) msg;

        //服务端正常情况返回码为200
        if (rpcResponse.getCode() != 200) {
            throw new Exception();
        }

        //将结果放到future里
        ClientNetty.future.complete(rpcResponse.getResult());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}