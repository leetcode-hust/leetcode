package netty.quanwei.p3;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by louyuting on 17/1/31.
 * netty 时间服务器 服务端
 */
public class TimeServer {

    public void bind(int port) throws Exception{
        //配置服务端NIO 线程组
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap server = new ServerBootstrap();

        try {
            server.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelInitializer());

            //绑定端口, 同步等待成功
            ChannelFuture future = server.bind(port).sync();

            //等待服务端监听端口关闭
            future.channel().closeFuture().sync();
        } finally {
            //优雅关闭 线程组
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    /**
     * main 函数
     * @param args
     */
    public static void main(String[] args) {
        TimeServer server = new TimeServer();
        try {
            server.bind(18888);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
