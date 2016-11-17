package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by LL on 2016/10/29.
 */
public class ChannelCopy {

    private static final int BSIZE=1024;

    public static void main(String[] args) throws Exception{

        if(args.length != 2){
            System.out.println("参数长度不是2");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();

        ByteBuffer buff = ByteBuffer.allocateDirect(BSIZE);
        while (in.read(buff)!=-1){
            buff.flip();
            out.write(buff);
            buff.clear();
        }

        //写一个文件:通过FileOutputStream来获取通道
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text!".getBytes()));
        fc.close();

        //在文件末尾添加
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size());//把指针移动到文件末尾
        fc.write(ByteBuffer.wrap("somethig more".getBytes()));
        fc.close();

    }
}















