package netty.cookbook.simplechat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import utils.LogUtil;

/**
 * Created by louyuting on 16/12/8.
 * 客户端处理IO,只需要将读到的信息打印出来就OK了
 */
public class SimpleChatClientHandler extends SimpleChannelInboundHandler<String>{

    /**
     * 每当从服务端读到客户端写入信息时,将信息转发给其他客户端的Channel.
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        LogUtil.log_debug(msg);
    }

}
