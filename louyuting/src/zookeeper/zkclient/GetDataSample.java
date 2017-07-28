package zookeeper.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * Created by louyuting on 2017/6/7.
 */
public class GetDataSample {
    public static void main(String[] args) throws InterruptedException {
        ZkClient zkClient = new ZkClient("123.206.13.151:2181", 5000);
        String path = "/zk-book";
        zkClient.createEphemeral(path, "123");

        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                //数据节点的path， data是最新的数据
                System.out.println("Node:[" + dataPath + "] changed data, new data is: [" + data + "]");
            }
            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("Node:[" + dataPath + "] deteled!");
            }
        });

        System.out.println( (String) zkClient.readData(path) );

        zkClient.writeData(path, "456");
        Thread.sleep(100);
        zkClient.delete(path);
        Thread.sleep(100000);
    }
}
