package patterns.singleton_multi;

import java.util.concurrent.TimeUnit;

/**
 * Created by louyuting on 17/1/22.
 * synchronized 同步代码块实现线程安全
 */
public class Singleton4 {
    //单例
    private static Singleton4 instance;

    //构造器私有,不开放
    private Singleton4(){

    }

    public static Singleton4 getInstance(){
        //创建实例前一些耗时操作
        try {
            synchronized (Singleton4.class){
                if(instance==null){
                    TimeUnit.MILLISECONDS.sleep(300);
                    instance = new Singleton4();
                }else {
                    //instance非空
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instance;
    }

}
