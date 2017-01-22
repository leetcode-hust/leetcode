package netty.cookbook.simplechat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Created by louyuting on 16/12/8.
 * 服务端处理IO
 */
public class SimpleChatServerHandler extends SimpleChannelInboundHandler<String>{

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 每当服务端收到新的客户端连接时,客户端的channel存入ChannelGroup列表中,并通知列表中其他客户端channel
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //super.handlerAdded(ctx);
        Channel incomming = ctx.channel();
        for(Channel channel:channels){
            channel.writeAndFlush("[SERVER]-"+incomming.remoteAddress()+"加入\n");
        }

        channels.add(ctx.channel());
    }

    /**
     *每当服务端断开客户端连接时,客户端的channel从ChannelGroup中移除,并通知列表中其他客户端channel
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        //super.handlerRemoved(ctx);
        Channel incomming = ctx.channel();
        for(Channel channel:channels){
            channel.writeAndFlush("[SERVER]-"+incomming.remoteAddress()+"离开\n");
        }

        channels.remove(ctx.channel());
    }

    /**
     * 每当从服务端读到客户端写入信息时,将信息转发给其他客户端的Channel.
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel incomming = ctx.channel();
        for(Channel channel:channels){
            if(channel != incomming) {
                channel.writeAndFlush("[" + incomming.remoteAddress() + "]" + msg + "\n");
            }else{
                channel.writeAndFlush("[You]"+msg+"\n");
            }
        }
    }

    /**
     * 服务端监听到客户端活动
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:" + incoming.remoteAddress()+"在线");
    }

    /**
     * 服务端监听到客户端不活动
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //super.channelInactive(ctx);
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:" + incoming.remoteAddress()+"掉线");
    }

    /**
     * 当服务端的IO 抛出异常时被调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:" + incoming.remoteAddress()+"异常");
        //异常出现就关闭连接
        cause.printStackTrace();
        ctx.close();

    }
}
