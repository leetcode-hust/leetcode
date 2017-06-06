package zookeeper.zookeeper.main;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import utils.LogUtil;
import zookeeper.zookeeper.watcher.ConnectionWatcher;

import java.util.concurrent.CountDownLatch;

/**
 * Created by louyuting on 2017/6/6.
 *
 * 测试： Zookeeper的连接，同步连接;
 */
public class ConnectionZookeeper {
    protected ZooKeeper zk;// client
    protected CountDownLatch latch = new CountDownLatch(1);// 闭锁

    public void connect() throws Exception{
        zk = new ZooKeeper(Constant.HOST1, Constant.SESSION_TIMEOUT,
                new ConnectionWatcher(latch));
        latch.await();// 等待连接完毕
    }

    public void connect(Watcher watcher) throws Exception{
        this.zk = new ZooKeeper(Constant.HOST1, Constant.SESSION_TIMEOUT,
                watcher);
        latch.await();// 等待连接完毕
    }

    /**
     * 创建结点
     * @param nodeName  结点的名称，不需要以/开头
     * @throws Exception
     */
    public void create(String nodeName) throws Exception{
        String path = "/" + nodeName;
        // 默认不加 ACL
        String createdPath = zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        LogUtil.log_debug(" created " + createdPath);

    }
    /**
     * 创建结点
     * @param nodeName  结点的名称，不需要以 / 开头
     * @param value   结点的数据
     * @throws Exception
     */
    public void create(String nodeName, String value) throws Exception{
        String path = "/" + nodeName;
        // 默认不加 ACL， 即结点的任何操作都不受权限控制
        String createdPath = zk.create(path, value.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        LogUtil.log_debug("createdPath：" + createdPath);
    }


    public void close() throws Exception{
        zk.close();
    }

    public ZooKeeper getZk() {
        return zk;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(Constant.HOST1, Constant.SESSION_TIMEOUT,
                new ConnectionWatcher(latch));
        System.out.println("zookeeper 的连接状态是：" + zooKeeper.getState());
        latch.await();// 等待连接成功
        System.out.println("zookeeper 已经连接成功，连接状态是：" + zooKeeper.getState());
    }
}
