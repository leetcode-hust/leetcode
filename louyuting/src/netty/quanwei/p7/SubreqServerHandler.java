package netty.quanwei.p7;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import utils.LogUtil;

/**
 * Created by louyuting on 17/1/31.
 */
public class SubreqServerHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        LogUtil.log_debug("Server -> read");

        SubscribeReq req = (SubscribeReq)msg;

        if( "louyuting".equalsIgnoreCase(req.getUserName()) ){
            System.out.println("service accept client subscript req :[\n"+ req.toString() +"]");

            ctx.writeAndFlush( resp(req.getMessageID()) );
        }
    }

    private SubscribeResp resp(String reqID){
        SubscribeResp response = new SubscribeResp();
        response.setMessageID(reqID);
        response.setRespCode("0");
        response.setDescription("subscribe is success book will arrive after 3 days");
        return response;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        LogUtil.log_debug("Server -> read complete");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //释放资源
        ctx.close();
    }
}


