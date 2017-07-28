package zookeeper.zkclient;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by louyuting on 2017/6/7.
 */
public class GetChildrenSample {

    public static void main(String[] args) throws InterruptedException {
        ZkClient zkClient = new ZkClient("123.206.13.151:2181", 5000);
        String path = "/zk-book";
        if(!zkClient.exists(path)){
            zkClient.createPersistent(path);
        }
        // 注册监听器
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println(parentPath + ". it's child changed, currentChilds: " + currentChilds);
            }
        });
        System.out.println(zkClient.getChildren("/zk-book"));
        Thread.sleep(1000);
        zkClient.createPersistent(path+"/c1");
        Thread.sleep(1000);
        zkClient.delete(path+"/c1");
        Thread.sleep(1000);
        //zkClient.delete(path);

        System.out.println("////////////////////////");
        Thread.sleep(1000000);
    }
}
