package netty.quanwei.p4_2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import utils.LogUtil;

/**
 * Created by louyuting on 17/1/31.
 * 链路建立成功时发送100条消息到服务端, 每发送一条就刷新一次数据到SocketChannel,保证每条消息都被及时写入到channel
 * 按逻辑服务端应该接收到100条查询时间的指令.
 *
 * 此外,客户端每收到一次响应就打印一次响应
 *
 */
public class TimeCLientHandler extends ChannelInboundHandlerAdapter{
    private byte[] req;

    private int counter;

    public TimeCLientHandler() {
        this.req = ("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
    }


    /**
     * 链路建立成功时发送100条消息到服务端, 每发送一条就刷新一次数据到SocketChannel
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LogUtil.log_debug("client -> active");
        ByteBuf message=null;

        for(int i=0; i<100; i++){
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        LogUtil.log_debug("client -> read");

        String body = (String)msg;

        LogUtil.log_debug("NOW is: " + body + " the counter is:" + (++counter));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
