package zookeeper.zookeeper.main;

import org.apache.zookeeper.Watcher;

/**
 * Created by louyuting on 2017/6/6.
 *
 * 默认是同步获取， method 后面加了 Async 的表示是异步获取的。
 */
public interface ZookeeperMethod {

    public void connect() throws Exception;

    public void connect(String host) throws Exception;

    public void connect(Watcher watcher) throws Exception;

    public void create(String nodeName) throws Exception;

    public void create(String nodeName, String value) throws Exception;



}
