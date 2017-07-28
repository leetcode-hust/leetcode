package zookeeper.zkclient.distributedlock.exclusive;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * Created by louyuting on 2017/6/7.
 * 分布式锁： 排它锁的实现：
 *  通过Zookeeper的一个数据结点来表示一个锁，例如 /exclusive_lock/lock 结点可以被定义成一个锁。
 *
 *  获取锁：所有客户端都会试图去通过调用 create()接口去创建临时结点/exclusive_lock/lock来表示想获取锁，
 *         注意这里使用临时结点是为了防止死锁。 Zookeeper会保证在所有客户端中，最终只有一个客户端能够创建
 *         成功，那么就可以认为该客户端获取到了锁。 同时没有获取到锁的客户端就需要到/exclusive_lock结点
 *         上注册一个 watcher监听，以便随时监听到lock 结点的变更情况。
 *
 *  释放锁：对于lock结点是临时结点，所以释放锁有两种情况：
 *          1）当前获取锁客户端宕机了， Zookeeper会删除这个临时结点；
 *          2）client正常执行逻辑之后会主动将自己创建的临时结点删除
 *
 *         只要结点被删除了，就会Zookeeper都会通知所有在/exclusive_lock 上注册了子结点变更watcher监听
 *         的客户端，这些客户端会再次重新发起分布式锁的获取，即重复获取锁的过程。
 */
public class ExclusiveLock {
    private ZkClient zkClient;

    public ExclusiveLock(ZkClient zkClient) {
        this.zkClient = zkClient;
        zkClient.createPersistent("/exclusive_lock");

        zkClient.subscribeChildChanges("/exclusive_lock", new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {

                if(currentChilds.size() == 0){
                    // 其余的client 解锁了
                    lock();
                }

            }
        });
    }

    public void lock(){
        zkClient.createEphemeral("/exclusive_lock/lock");
    }


    public void unlock(){
        zkClient.delete("/exclusive_lock/lock");
    }





}
