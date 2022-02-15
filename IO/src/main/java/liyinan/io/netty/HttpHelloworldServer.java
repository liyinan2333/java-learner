package liyinan.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author : liyinan2333
 * @date: 2022/02/15
 */
public class HttpHelloworldServer {

    public static void main(String[] args) throws InterruptedException {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        // 启动器的一系列配置
        bootstrap
                // 父channel配置
                .option(ChannelOption.SO_BACKLOG, 1024)
                // 子channel配置
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                // 配置父channel的handler
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(new HttpServerCodec());
                        // 未实现，详见netty-example,或my-rpc-framework
//                        pipeline.addLast(new HttpHelloworldServerHandler());
                    }
                });
        try {
            // 绑定端口，启动服务
            ChannelFuture future = bootstrap.bind(8080).sync();
            // 阻塞等待关闭
            future.channel().closeFuture().sync();
        } finally {
            // 优雅的关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }

}
