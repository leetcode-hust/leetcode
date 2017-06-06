package zookeeper.zookeeper.main;

import org.apache.zookeeper.ZooKeeper;
import zookeeper.zookeeper.watcher.ConnectionWatcher;

import java.util.concurrent.CountDownLatch;

/**
 * Created by louyuting on 2017/6/6.
 *
 * 测试： Zookeeper的连接，同步连接，连接复用
 */
public class ConnectionZookeeperMultiplexed {

    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(Constant.HOST1, Constant.SESSION_TIMEOUT,
                new ConnectionWatcher(latch));
        System.out.println("zookeeper 的连接状态是：" + zooKeeper.getState());
        latch.await();// 等待连接成功
        System.out.println("zookeeper 已经连接成功，连接状态是：" + zooKeeper.getState());
        //获取当前连接的 sessionId 和 passwd
        long sessionId = zooKeeper.getSessionId();
        byte[] sessionPasswd = zooKeeper.getSessionPasswd();
        //复用会话, illegal 非合法的
        System.out.println("\n第二次连接，非法复用连接：");
        zooKeeper = new ZooKeeper(Constant.HOST1, Constant.SESSION_TIMEOUT,
                new ConnectionWatcher(latch), 1l, sessionPasswd);
        latch.await();// 等待连接成功

        System.out.println("\n");
        System.out.println("\n第三次连接，合法复用连接：");
        zooKeeper = new ZooKeeper(Constant.HOST1, Constant.SESSION_TIMEOUT,
                new ConnectionWatcher(latch), sessionId, sessionPasswd);
        latch.await();// 等待连接成功
        System.out.println("\n");
    }
}
