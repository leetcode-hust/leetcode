package patterns.watcher;

/**
 * Created by louyuting on 2017/2/13.
 * 具体的主题角色,当调用change函数时要通知 各个观察者.
 */
public class ConcreteSubject extends Subject {

    private String state;//状态

    public String getState()
    {
        return state;
    }

    public void change(String newState)
    {
        state = newState;
        System.out.println("主题状态为：" + state);

        // 状态发生改变时，通知各个观察者
        this.notifyObservers(state);
    }




}
