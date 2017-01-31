package netty.quanwei.p5;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.net.InetSocketAddress;

/**
 * Created by louyuting on 16/11/27.
 */
public class EchoClient {
    private final String host;
    private final int port;//定义服务器端监听的端口
    /** 构造函数中传入参数 **/
    public EchoClient(String host, int port){
        this.host = host;
        this.port = port;
    }

    /** 启动服务器 **/
    public void start() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        //创建一个client 的bootstrap实例
        Bootstrap clientBootstrap = new Bootstrap();

        try {
            clientBootstrap.group(group)
                    .channel(NioSocketChannel.class)//指定使用一个NIO传输Channel
                    .remoteAddress(new InetSocketAddress(host, port))//设置远端服务器的host和端口
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        //在channel的ChannelPipeline中加入EchoClientHandler到最后
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
                            channel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,delimiter));

                            channel.pipeline().addLast(new StringDecoder());
                            channel.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            ChannelFuture f = clientBootstrap.connect().sync();//连接到远端,一直等到连接完成
            f.channel().closeFuture().sync();//一直阻塞到channel关闭
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
        new EchoClient("127.0.0.1", 8000).start();
    }

}