package patterns.singleton_multi;

import java.util.concurrent.TimeUnit;

/**
 * Created by louyuting on 17/1/22.
 * 懒汉式单例(延迟初始化)； 多线程下完全不安全
 */
public class Singleton2 {
    //单例
    private static Singleton2 instance;

    //构造器私有,不开放
    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        if(instance == null){
            //创建实例前一些耗时操作
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton2();
        }
        return instance;
    }

}
