package netty.cookbook;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by louyuting on 16/12/7.
 * 启动服务端
 */
public class DiscardServer {

    //端口号
    private int port;

    public DiscardServer(int port){
        this.port = port;
    }

    /**
     * run
     * @throws Exception
     */
    public void run() throws Exception{
        //NioEventLoopGroup是用来处理IO操作的多线程事件循环器
        //boss用来接收进来的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //用来处理已经被接收的连接;
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            //是一个启动NIO服务的辅助启动类
            ServerBootstrap sBootstrap = new ServerBootstrap();
            //These EventLoopGroup's are used to handle all the events and IO for ServerChannel and Channel's.
            //为bootstrap设置acceptor的EventLoopGroup和client的EventLoopGroup
            //这些EventLoopGroups用于处理所有的IO事件
            //?这里为什么设置两个group呢?
            sBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            //绑定端口,开始接收进来的连接
            ChannelFuture future = sBootstrap.bind(port).sync();

            //等待服务器socket关闭

            //在本例子中不会发生,这时可以关闭服务器了
            future.channel().closeFuture().sync();
        } finally {
            //
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port=8080;
        new DiscardServer(port).run();
    }

}
