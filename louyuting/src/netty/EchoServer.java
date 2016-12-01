package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by louyuting on 16/11/27.
 */
public class EchoServer {

    private final int port;//定义服务器端监听的端口


    public EchoServer(int port){
        this.port = port;
    }

    public void start() throws Exception{

        EventLoopGroup group = new NioEventLoopGroup();

        //创建一个serverbootstrap实例
        ServerBootstrap b = new ServerBootstrap();

        try {
            b.group(group).channel(NioServerSocketChannel.class).localAddress(port)
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            //binds server waits for server to close, and releases resources
            ChannelFuture f = b.bind().sync();
            System.out.println(EchoServer.class.getName()+" started and listen on '"+ f.channel().localAddress());
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }

    }

    public static void main(String[] args) throws Exception {
        new EchoServer(65535).start();
    }




}
