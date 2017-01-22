package patterns.singleton_multi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by louyuting on 17/1/22.
 * synchronized DCl
 */
public class Singleton6 {
    //使用volatile关键字保其可见性
    volatile private static Singleton6 instance;

    private static Lock lock = new ReentrantLock();

    //构造器私有,不开放
    private Singleton6(){

    }

    public static Singleton6 getInstance(){
        //创建实例前一些耗时操作
        try {
            if(instance==null){
                lock.lock();//加锁
                if(instance == null){//二次检查
                    TimeUnit.MILLISECONDS.sleep(300);
                    instance = new Singleton6();
                }
                lock.unlock();
            }else {
                //instance非空
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

        }
        return instance;
    }

}
