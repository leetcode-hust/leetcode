package zookeeper.zookeeper.watcher;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import utils.LogUtil;

import java.util.concurrent.CountDownLatch;

/**
 * Created by louyuting on 2017/6/6.
 *
 * 连接事件的 watcher 回调
 */
public class ConnectionWatcher implements Watcher{

    private CountDownLatch connectedLatch;// 闭锁，等待连接完成后开放闭锁。

    public ConnectionWatcher(CountDownLatch countDownLatch) {
        this.connectedLatch = countDownLatch;
    }

    @Override
    public void process(WatchedEvent event) {
        LogUtil.log_debug("reveive watched event: " + event);
        LogUtil.log_debug("当前event 连接状态是：" + event.getState());
        // 如果是连接事件
        if(event.getState() == Event.KeeperState.SyncConnected){
            // 唤醒
            connectedLatch.countDown();
        }
        LogUtil.log_debug("当前event type 是：" + event.getType());
        if(event.getType() == Event.EventType.None){
            LogUtil.log_debug("当前event 是连接事件。");
        }
    }
}
