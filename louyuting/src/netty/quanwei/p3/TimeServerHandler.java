package netty.quanwei.p3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import utils.DateUtil;
import utils.LogUtil;

import java.util.Date;

/**
 * Created by louyuting on 17/1/31.
 */
public class TimeServerHandler  extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        LogUtil.log_debug("Server -> read");

        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, "UTF-8");

        LogUtil.log_debug("timeServer received order: " + body);

        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)? DateUtil.fmtDateToMillisecond(new Date()) : "BAD ORDER";

        //response
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        //异步发送应答消息给客户端: 这里并没有把消息直接写入SocketChannel,而是放入发送缓冲数组中
        ctx.writeAndFlush(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        LogUtil.log_debug("Server -> read complete");

        //将发送缓冲区中数据全部写入SocketChannel
        //ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //释放资源
        ctx.close();
    }
}


