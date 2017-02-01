package netty.quanwei.p8;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import utils.LogUtil;

/**
 * Created by louyuting on 17/1/31.
 */
public class SubreqClientHandler extends ChannelInboundHandlerAdapter{

    public SubreqClientHandler() {
    }

    /**
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LogUtil.log_debug("client -> active");

        for(int i=0; i<10; i++){
            ctx.write(subReq(String.valueOf(i)));
        }
        // 写入10个对象到发送缓冲之后再一次性 flush写入通道
        ctx.flush();
    }


    private SubscribeReq subReq(String id){
        SubscribeReq req = new SubscribeReq();
        req.setMessageID(id);
        req.setUserName("louyuting");
        req.setProductName("iphone 7");
        req.setPhone("13026317652");
        req.setAddress("HUST");

        return req;
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        LogUtil.log_debug("client -> read");

        LogUtil.log_debug("receive server response: { " + msg.toString() +"]");

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
