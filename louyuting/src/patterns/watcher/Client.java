package patterns.watcher;

/**
 * Created by louyuting on 2017/2/13.
 */
public class Client {


    public static void main(String[] args) {

        /** 创建主题角色 */
        ConcreteSubject subject = new ConcreteSubject();

        /** 创建多个观察者对象 */
        for(int i=0; i<6; i++){
            Observer observer = new ConcreteObserver();
            /** 将观察者注册到主题对象上 */
            subject.attch(observer);
        }

        /** 改变主题对象的状态 */
        subject.change("new state");
    }




}
