package netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 *
 * Created by louyuting on 16/11/27.
 * 服务器端向客户端传输数据......
 *
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter{

    /**
     * 每次收到消息的时候被调用;
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        System.out.println("Server received: " + msg);
        ctx.write(msg);
    }

    /**
     * 用来通知handler,上一个ChannelRead()是被这批消息中的最后一个消息调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
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
