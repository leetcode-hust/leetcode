package netty;

import utils.LogUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Created by louyuting on 16/12/1.
 */
public class PlainOioServer {

    /**
     * 服务器端
     * @param port
     * @throws IOException
     */
    public void serve(int port) throws IOException{
        final ServerSocket socket = new ServerSocket(port);//将服务器绑定到指定的端口

        try {
            for (; ; ){
                //这里会阻塞等待连接
                final Socket clientSocket = socket.accept();//阻塞等待连接

                LogUtil.log_debug("Accepted connection from " + clientSocket);

                /** 创建一个新的线程来处理这个连接 */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            //写消息到这个已经建立了连接的客户端
                            out = clientSocket.getOutputStream();
                            out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                            out.flush();
                            clientSocket.close();//关闭客户端
                        } catch (IOException e){
                            e.printStackTrace();
                        }finally {
                            if(!clientSocket.isClosed()){
                                try {
                                    clientSocket.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }).start();//启动线程
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }



}
