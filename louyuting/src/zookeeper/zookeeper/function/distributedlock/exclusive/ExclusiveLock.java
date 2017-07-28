package zookeeper.zookeeper.function.distributedlock.exclusive;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import utils.LogUtil;
import zookeeper.zookeeper.main.Constant;
import zookeeper.zookeeper.watcher.ConnectionWatcher;

import java.util.concurrent.CountDownLatch;

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

    private static ZooKeeper zk;
    private static CountDownLatch latch;//闭锁

    static {
        //静态代码段里面首先创建 /exclusive_lock 这个结点，这个结点必须是永久的，作为分布式独占锁的父结点标识
        try {
            latch = new CountDownLatch(1);
            zk = new ZooKeeper(Constant.HOST1, Constant.SESSION_TIMEOUT,
                    new ConnectionWatcher(latch));
            latch.await();// 等待连接完毕
            //首先判断结点是否已经创建了：
            Stat stat = zk.exists("/exclusive_lock", false);
            System.out.println("stat是否是空：[\n"+stat+"]");
            if(stat == null){
                //同步创建结点
                String createPath = zk.create("/exclusive_lock", "".getBytes(),
                        ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                LogUtil.log_debug("创建根节点 /exclusive_lock 成功, 返回目录是："+ createPath);
            } else {
                System.out.println("/exclusive_lock 结点已经存在，不需要创建");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static class LockCallBack implements AsyncCallback.StringCallback{
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            // 如果结点已经存在了，那么就在父结点上注册监听器，观察结点的情况
            if(rc == Constant.ResultCode_NodeExists){
                try {
                    zk.exists("/exclusive_lock", new Watcher() {
                        @Override
                        public void process(WatchedEvent event) {
                            //首先得是连接状态
                            if(event.getState() == Event.KeeperState.SyncConnected){
                                // 在/exclusive_lock上注册一个 监听器，判断结点的子结点是否发生变化
                                if (event.getType() == Event.EventType.NodeChildrenChanged) {
                                    //重新发起 lock请求, 也就是创建结点


                                }
                            }
                        }
                    });
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {

            }
        }
    }


    /**
     * 加锁
     */
    public static void lock(){
        //所有客户端可能并发的访问lock 去向Zookeeper获取锁，所以获取锁也就是create;
        // 这里的create 必须是异步的， 因为异步回调中有服务端返回码
        zk.create("/exclusive_lock/lock", "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, new LockCallBack(), "try to get lock");
    }

    /**
     * 释放锁
     */
    public static void unlock(){

    }


    public static void main(String[] args) {

    }



}
