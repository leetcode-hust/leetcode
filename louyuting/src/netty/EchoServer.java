package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by louyuting on 16/11/27.
 */
public class EchoServer {
    private final int port;//定义服务器端监听的端口
    /** 构造函数中传入参数 **/
    public EchoServer(int port){
        this.port = port;
    }

    /** 启动服务器 **/
    public void start() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        //创建一个serverbootstrap实例
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        try {
            serverBootstrap.group(group)
                    .channel(NioServerSocketChannel.class)//指定使用一个NIO传输Channel
                    .localAddress(port)//用指定的端口设置socket地址
                    .childHandler(new ChannelInitializer<SocketChannel> () {
                        //在channel的ChannelPipeline中加入EchoServerHandler到最后
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            //异步的绑定服务器,sync()一直等到绑定完成.
            ChannelFuture future = serverBootstrap.bind().sync();
            System.out.println(EchoServer.class.getName()+" started and listen on '"+ future.channel().localAddress());
            future.channel().closeFuture().sync();//获得这个channel的CloseFuture,阻塞当前线程直到关闭操作完成
        } finally {
            group.shutdownGracefully().sync();//关闭group,释放所有的资源
        }
    }


    /**
     * main
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new EchoServer(8000).start();
    }

}








