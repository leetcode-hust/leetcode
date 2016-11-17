package nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by LL on 2016/10/29.
 */
public class ViewBuffers {

    private static final int BSIZE=1024;

    public static void main(String[] args) throws Exception{
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
        bb.rewind();//返回数据的最开始部分
        System.out.print("Byte Buffer");
        //判断buff的当前位置到limit之间是否还有其余的元素（position是否到了最后一个位置）
        while (bb.hasRemaining()){
            System.out.print(bb.position() + "->" + bb.get()+ ", \n");
        }


        CharBuffer cb = ((ByteBuffer)bb.rewind()).asCharBuffer();
        System.out.print("char Buffer");
        while (cb.hasRemaining()){
            System.out.print(cb.position() + "->" + cb.get()+ ", \n");
        }
    }
}















