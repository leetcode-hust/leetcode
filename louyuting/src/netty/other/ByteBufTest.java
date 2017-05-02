package netty.other;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * Created by louyuting on 16/12/16.
 */
public class ByteBufTest {


    public static void main(String[] args) {
        //创建一个16字节的buffer
        ByteBuf buf = Unpooled.buffer(16);
        //写数据到buffer
        for(int i=0; i<16; i++){
            buf.writeByte(i+1);
        }
        //读数据
        for(int i=0; i<buf.capacity(); i++){
            System.out.print(buf.getByte(i)+", ");
        }

    }


}
