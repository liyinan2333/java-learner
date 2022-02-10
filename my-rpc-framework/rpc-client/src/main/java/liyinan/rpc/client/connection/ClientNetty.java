package liyinan.rpc.client.connection;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import liyinan.rpc.client.handler.ClientHandler;
import liyinan.rpc.core.entity.RpcResponse;
import liyinan.rpc.core.protocol.NettyProtocolHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;

/**
 * @author liyinan2333
 * @date 2022/2/10
 */
public class ClientNetty {

    public static Channel channel;
    // 存放反序列化后的请求结果
    public static CompletableFuture future = new CompletableFuture();

    public static void connect(String host, int port) throws InterruptedException {

        // 流处理器
        InetSocketAddress address = new InetSocketAddress(host, port);
        EventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class)
                .group(workGroup)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        //自定义协议handler（客户端接收的是response）
                        channel.pipeline().addLast(new NettyProtocolHandler(RpcResponse.class));
                        //处理数据handler
                        channel.pipeline().addLast(new ClientHandler());
                    }
                });

        channel = bootstrap.connect(address).sync().channel();
    }
}