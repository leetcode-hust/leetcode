package nio;

import utils.LogUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Created by louyuting on 16/12/1.
 */
public class SocketChannelDemo {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        //这里必须填写域名才能正确返回
        boolean result = socketChannel.connect(new InetSocketAddress("120.25.12.92", 80));
        LogUtil.log_debug(""+result);
        socketChannel.close();
        ///~output
        // true
    }
}
