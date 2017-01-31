package netty.quanwei.p3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import utils.LogUtil;

/**
 * Created by louyuting on 17/1/31.
 */
public class TimeCLientHandler extends ChannelInboundHandlerAdapter{
    private final ByteBuf firstMSG;

    public TimeCLientHandler() {
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMSG = Unpooled.buffer(req.length);
        firstMSG.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LogUtil.log_debug("client -> active");

        ctx.writeAndFlush(firstMSG);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        LogUtil.log_debug("client -> read");

        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, "UTF-8");

        LogUtil.log_debug("NOW is: " + body);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
