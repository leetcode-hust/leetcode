package zookeeper.zookeeper.watcher;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import utils.LogUtil;
import zookeeper.zookeeper.main.ConnectionZookeeper;

import java.util.concurrent.CountDownLatch;

/**
 * Created by louyuting on 2017/6/6.
 * 子结点变化 监听器
 */
public class NodeChildrenChangedWatcher implements Watcher {

    private CountDownLatch connectedLatch;// 闭锁，等待连接完成后开放闭锁。
    private ConnectionZookeeper connectionZookeeper;

    public NodeChildrenChangedWatcher(CountDownLatch countDownLatch, ConnectionZookeeper cz) {
        this.connectedLatch = countDownLatch;
        this.connectionZookeeper = cz;
    }

    @Override
    public void process(WatchedEvent event) {
        // 确保是连接状态
        if(Event.KeeperState.SyncConnected == event.getState()){
            // 连接的watcher
            if(Event.EventType.None == event.getType()){
                connectedLatch.countDown();
            } else if (Event.EventType.NodeChildrenChanged == event.getType()){
                //子节点变化
                try {
                    // 重新获取结点数据，然后打印出来
                    LogUtil.log_debug(""+event);
                    LogUtil.log_debug("zooKeeper是否为空"+connectionZookeeper.getZk());
                    LogUtil.log_debug("reGetChild:" + connectionZookeeper.getZk().getChildren(event.getPath(), true));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
