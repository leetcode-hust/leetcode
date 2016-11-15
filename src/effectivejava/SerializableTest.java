package effectivejava;

import java.io.*;
import java.util.Date;

/**
 * Created by louyuting on 16/11/11.
 * 序列化与反序列化
 */
public class SerializableTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //获取序列化对象
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/opt/objectFile.obj"));

        Customer customer = new Customer("娄宇庭", "24");
        out.writeObject("你好!");
        out.writeObject(new Date());
        out.writeObject(customer);
        out.close();

        //反序列化对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/opt/objectFile.obj"));
        System.out.println("obj1:"+ (String)in.readObject());
        System.out.println("obj2:"+ (Date)in.readObject());
        System.out.println("obj3:"+ (Customer)in.readObject());
        in.close();

    }

}
