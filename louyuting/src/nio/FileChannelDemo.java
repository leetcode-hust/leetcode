package nio;

import org.junit.Test;
import utils.LogUtil;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by louyuting on 16/11/29.
 */
public class FileChannelDemo {


    public static void main(String[] args) {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("dataStructure.txt", "rw");
            FileChannel inchannel = accessFile.getChannel();//获取 FileChannel

            ByteBuffer buffer = ByteBuffer.allocate(48);//申请48字节的缓冲区
            int bytesRead = inchannel.read(buffer);// 读取数据放入缓冲区

            while(bytesRead != -1){
                System.out.println("read " + bytesRead);
                Thread.sleep(500);
                buffer.flip();
                bytesRead=-1;
            }
            while(buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            bytesRead = inchannel.read(buffer);
            accessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void channelToChannel() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();//获取source的通道;

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();//获取dest的通道;

        long position = 0;
        long count = fromChannel.size();

        long result = toChannel.transferFrom(fromChannel, position, count);

        LogUtil.log_debug(""+result);

    }
    @Test
    public void channelToChannel_2() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();//获取source的通道;

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();//获取dest的通道;

        long position = 0;
        long count = fromChannel.size();

        long result = fromChannel.transferTo(position, count, toChannel);

        LogUtil.log_debug(""+result);

    }




}
