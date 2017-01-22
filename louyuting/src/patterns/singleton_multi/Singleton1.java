package patterns.singleton_multi;

/**
 * Created by louyuting on 17/1/22.
 * 饿汉式单例模式
 */
public class Singleton1 {
    //单例
    private static Singleton1 instance = new Singleton1();

    //构造器私有,不开放
    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        return instance;
    }

}
