package netty.cookbook;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by louyuting on 16/12/7.
 * 服务器端的Handler.
 * ChannelInboundHandlerAdapter实现了ChannelInboundHandler接口
 * ChannelInboundHandler接口提供了很多事件处理的接口方法.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{
    /**
     * 每当从客户端收到新的数据时,这个方法会在收到消息时被调用.
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        //应答服务器
//        ByteBuf in = (ByteBuf)msg;
//        try {
//            while(in.isReadable()){
//                System.out.print((char)in.readByte());
//                System.out.flush();
//            }
//        }finally {
//            ReferenceCountUtil.release(msg);
//        }
        ctx.writeAndFlush(msg);
        //默默的丢弃收到的数据
        //((ByteBuf)msg).release();
    }

    /**
     * 当抛出异常时调用该方法
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        //每当出现异常是就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
