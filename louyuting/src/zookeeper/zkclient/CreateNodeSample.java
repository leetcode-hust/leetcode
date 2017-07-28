package zookeeper.zkclient;

import org.I0Itec.zkclient.ZkClient;

/**
 * Created by louyuting on 2017/6/7.
 */
public class CreateNodeSample {

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient("123.206.13.151:2181", 5000);
        zkClient.createPersistent("/zk-book", true);
    }

}
