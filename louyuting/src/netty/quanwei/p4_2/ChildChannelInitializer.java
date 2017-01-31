package netty.quanwei.p4_2;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by louyuting on 17/1/31.
 */
public class ChildChannelInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        channel.pipeline().addLast(new LineBasedFrameDecoder(1024));

        channel.pipeline().addLast(new StringDecoder());

        channel.pipeline().addLast("timeServerHandler", new TimeServerHandler());
    }
}
