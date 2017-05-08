package patterns.watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by louyuting on 2017/2/13.
 */
public abstract class Subject {
    /** 用来保存注册的观察者对象 */
    private List<Observer> list = new ArrayList<Observer>();

    /** 注册观察者对象 */
    public void attch(Observer observer)
    {
        list.add(observer);
        System.out.println("Attached an observer");
    }

    /** 删除观察者对象 */
    public void detach(Observer observer)
    {
        list.remove(observer);
        System.out.println("Detached an observer");
    }

    /** 通知所有注册的观察者对象 */
    public void notifyObservers(String newState)
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.get(i).update(newState);
        }
    }

}
