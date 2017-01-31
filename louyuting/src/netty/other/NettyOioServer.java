package netty.other;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by louyuting on 16/12/2.
 * 采用netty的阻塞网络
 */
public class NettyOioServer {

    public void server(int port) throws Exception {
        final ByteBuf buf = Unpooled.unreleasableBuffer(
                Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8")));

        //使用Oio
        EventLoopGroup group = new OioEventLoopGroup();

        try {
            //创建一个bootstrap
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group)
                    .channel(OioServerSocketChannel.class) //使用Oio,允许阻塞模式
                    .localAddress(new InetSocketAddress(port))
                    //确定每个新接受连接都会调用的ChannelInitializer
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //写数据到客户端并且添加ChannelFutureListener,一旦消息写完就关闭连接
                            socketChannel.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);
                        }
                    });
            //绑定服务器来接受新的请求
            ChannelFuture future = bootstrap.bind().sync();
        } finally {
            //释放所有资源
            group.shutdownGracefully().sync();
        }
    }


}
