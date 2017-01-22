package patterns.singleton_multi;

import java.util.concurrent.TimeUnit;

/**
 * Created by louyuting on 17/1/22.
 * synchronized 同步方法实现线程安全
 */
public class Singleton3 {
    //单例
    private static Singleton3 instance;

    //构造器私有,不开放
    private Singleton3(){

    }

    public synchronized static Singleton3 getInstance(){
        if(instance == null){
            //创建实例前一些耗时操作
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton3();
        }
        return instance;
    }

}
