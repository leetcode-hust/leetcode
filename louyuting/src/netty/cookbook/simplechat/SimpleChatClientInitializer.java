package netty.cookbook.simplechat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by louyuting on 16/12/8.
 * 用来增加多个的处理类到ChannelPipeline上:包括编码,解码,SimpleChatServerHandler
 */
public class SimpleChatClientInitializer extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //解码器inbound 入站解码
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        //解码器 inbound 入站解码
        pipeline.addLast("decoder", new StringDecoder());
        //编码器,outbound 出站编码
        pipeline.addLast("encoder", new StringEncoder());
        //编码器 inbound 入站数据
        pipeline.addLast("handler", new SimpleChatClientHandler());
    }
}
