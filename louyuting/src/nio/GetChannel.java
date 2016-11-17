package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by LL on 2016/10/29.
 */
public class GetChannel {

    private static final int BSIZE=1024;

    public static void main(String[] args) throws Exception{
        //写一个文件:通过FileOutputStream来获取通道
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text!".getBytes()));
        fc.close();

        //在文件末尾添加
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size());//把指针移动到文件末尾
        fc.write(ByteBuffer.wrap("somethig more".getBytes()));
        fc.close();

        //读文件
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);//创建一个缓冲区并指定大小
        fc.read(buff);//读取文本并放入缓冲区中
        buff.flip();//flip()函数有两个作用：
        //1. 把limit设置为当前的position值
        //2. 把position设置为0
        //然后处理的数据就是从position到limit直接的数据，也就是你刚刚读取过来的数据，方便读取。
        while (buff.hasRemaining())
            System.out.print((char)buff.get());



    }
}















