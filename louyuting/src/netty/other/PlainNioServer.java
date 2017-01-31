package netty.other;

import utils.LogUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by louyuting on 16/12/1.
 */
public class PlainNioServer {

    /**
     * 服务器端
     * @param port
     * @throws IOException
     */
    public void serve(int port) throws IOException{
        //打开NIO的ServerSocket通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        //配置成非阻塞类型
        serverChannel.configureBlocking(false);
        //获取与此通道关联的服务器套接字。
        ServerSocket ssocket = serverChannel.socket();
        //创建套接字地址，其中 IP 地址为通配符地址，端口号为指定值。
        InetSocketAddress address = new InetSocketAddress(port);
        //服务器套接字绑定地址和端口
        ssocket.bind(address);

        //打开Selector来处理channel
        Selector selector = Selector.open();
        //将channel注册到selector中,并将channel设置成等待新的连接
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        //创建一个新的,并存入数据
        final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes(Charset.forName("UTF-8")));

        for( ; ; ){
            try {
                //等待处理新的事件;一直阻塞直到下一个事件到来才唤醒.
                //此方法执行处于阻塞模式的选择操作。仅在至少选择一个通道、
                //调用此选择器的 wakeup 方法，或者当前的线程已中断（以先到者为准）后此方法才返回。
                selector.select();
            } catch (IOException e){
                e.printStackTrace();
                break;
            }

            //获取所有收到的事件的SelectionKey实例
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();

            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    //查看这个事件是否是一个等待接受的新连接请求
                    if (key.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel)key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        //将客户端的socket注册到selector中,并设置监听读和写的事件
                        client.register(selector,
                                SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());

                        LogUtil.log_debug("Accepted connection from " + client);
                    }
                    //查看这个socket是否已经准备好被写入数据
                    if(key.isWritable()){
                        SocketChannel client = (SocketChannel)key.channel();
                        //获取附加的对象
                        ByteBuffer buffer = (ByteBuffer)key.attachment();

                        while (buffer.hasRemaining()){
                            if( client.write(buffer) == 0){//写数据到这个连接的客户端
                                break;
                            }
                        }
                        client.close();//关闭连接
                    }
                } catch (IOException e){
                    key.cancel();
                    key.channel().close();
                }
            }
        }
    }



}
