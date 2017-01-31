package netty.quanwei.p4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import utils.DateUtil;
import utils.LogUtil;

import java.util.Date;

/**
 * Created by louyuting on 17/1/31.
 *
 * 收到消息之后就计数一次, 然后发送应答消息给客户端.
 * 按照这种设计, 逻辑上应该是服务端收到的消息总数和客户端发送的消息总数相同;
 * 请求消息删除回车换行符之后应该是 "QUERY TIME ORDER"
 *
 */
public class TimeServerHandler  extends ChannelInboundHandlerAdapter{

    private int counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        LogUtil.log_debug("Server -> read");

        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, "UTF-8").substring(0, req.length - System.getProperty("line.separator").length());

        LogUtil.log_debug("timeServer received order: " + body + "the counter is:" + (++counter)) ;

        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)? DateUtil.fmtDateToMillisecond(new Date()) : "BAD ORDER";
        currentTime = currentTime + System.getProperty("line.separator");

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


