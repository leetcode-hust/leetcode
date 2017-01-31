package netty.quanwei.p5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 *
 * Created by louyuting on 16/11/27.
 * 服务器端向客户端传输数据......
 *
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter{

    private int counter=0;
    /**
     * 每次收到消息的时候被调用;
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String)msg;

        System.out.println("this is:"+ (++counter) +" time." + " Server received: " + body);

        body = body + "$_";

        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());

        ctx.writeAndFlush(echo);
    }


    /**
     * 在读操作异常被抛出时被调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();//打印异常的堆栈跟踪信息
        ctx.close();//关闭这个channel
    }

}
