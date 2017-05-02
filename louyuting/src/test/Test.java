package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/10/29.
 */
public class Test {

    public static int i=0;

    public static int testtest(){
        try {
            i=10;
            System.out.println("try");
            return i;
        }finally {
            i=100;
            System.out.println("finally: " + i);
        }
    }

    @org.junit.Test
    public void test1(){
        System.out.println("test:"+ testtest());

        System.out.println(i);

    }


    public static void main(String[] args) {
        Test tt  = new Test();
    }


    /**
     * 测试 start()方法和 run()方法
     */
    @org.junit.Test
    public void array(){
        System.out.println("thread1");

        Thread my = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MICROSECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread3");
            }
        });
        my.run();
        System.out.println("thread2");
    }
    /**
     * 测试 start()方法和 run()方法
     */
    @org.junit.Test
    public void tttt(){
        System.out.println("thread1");

        Thread my = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MICROSECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread3");
            }
        });
        my.start();
        System.out.println("thread2");
    }

    @org.junit.Test
    public void main(){
        int[] a1 = new int[22];

        List<String> list = new ArrayList<>();

        String str1 = "11111";
        String str2 = "11111";

        if(str1==str2){
            System.out.println(str1.hashCode());
        }

        str2="22222"    ;
        System.out.println(str1.equals(str2));
    }




    /**
     * 测试transient关键字
     */
    @org.junit.Test
    public void mainnnn() {
        Obj o = new Obj();
        o.setDate(new Date());
        o.setClassValue(11);
        o.setTe(333);
        Obj.staticValue=20;

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("hello")));
            out.writeObject(o);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Obj o1=null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("hello")));
            o1 = (Obj)in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(o1.classValue);
        System.out.println(o1.getTe());

        System.out.println((o1.date == null ? "date is null"
                : "date is not null"));
    }

    @org.junit.Test
    public void test0(){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @org.junit.Test
    public void testClass() throws ClassNotFoundException {
        System.out.println(Test.class.getName());
        Class test = Class.forName("test.Test");
        System.out.println(test.getName());

    }

}


















