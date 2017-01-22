package patterns.singleton_multi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by louyuting on 17/1/22.
 * synchronized 同步代码块实现线程安全
 */
public class Singleton5 {
    //单例
    private static Singleton5 instance;

    private static Lock lock = new ReentrantLock();

    //构造器私有,不开放
    private Singleton5(){

    }

    public static Singleton5 getInstance(){
        //创建实例前一些耗时操作
        try {
            lock.lock();//加锁
            if(instance==null){
                TimeUnit.MILLISECONDS.sleep(300);
                instance = new Singleton5();
            }else {
                //instance非空
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return instance;
    }

}
