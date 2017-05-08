package patterns.watcher;

/**
 * Created by louyuting on 2017/2/13.
 */
public class ConcreteObserver implements Observer {

    /** 观察者的状态 */
    private String observerState;

    @Override
    public void update(String state) {
        /** 更新观察者的状态 */
        this.observerState = state;
        System.out.println("状态为：" + this.observerState);
    }
}
