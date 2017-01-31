package netty.other;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 *
 * Created by louyuting on 16/12/1.
 *
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf>{

    /**
     * 当收到连接成功的通知,发送一条消息.
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks! ", CharsetUtil.UTF_8));
    }

    /**
     * 每当收到数据时这个方法会被调用.打印收到的消息日志
     * @param channelHandlerContext
     * @param byteBuf
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        System.out.println("client received: " + byteBuf.toString(CharsetUtil.UTF_8));
    }

    /**
     * 异常发生时,记录错误日志,关闭channel
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();//打印堆栈的错误日志
        ctx.close();
    }

}
