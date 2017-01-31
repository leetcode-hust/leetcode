package netty.quanwei.p3;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by louyuting on 17/1/31.
 */
public class ChildChannelInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast("timeServerHandler", new TimeServerHandler());
    }
}
