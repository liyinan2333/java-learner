package liyinan.rpc.server.connection;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import liyinan.rpc.core.entity.RpcRequest;
import liyinan.rpc.core.protocol.NettyProtocolHandler;
import liyinan.rpc.server.handler.ServerHandler;

/**
 * @author liyinan2333
 * @date 2022/2/10
 */
public class ServerNetty {

    public static void connect(int port) throws InterruptedException {

        // 流处理器
        EventLoopGroup workGroup = new NioEventLoopGroup();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.channel(NioServerSocketChannel.class)
                .group(bossGroup, workGroup)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        /**
                         * 加入自定义协议的数据处理器，指定接收到的数据类型
                         * 加入服务端处理器
                         */
                        channel.pipeline().addLast(new NettyProtocolHandler(RpcRequest.class));
                        channel.pipeline().addLast(new ServerHandler());
                    }
                });

        bootstrap.bind(port).sync();
    }
}