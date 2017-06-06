package zookeeper.zookeeper.test;

import org.junit.Test;
import zookeeper.zookeeper.main.CreateNodeAsync;
import zookeeper.zookeeper.main.CreateNodeSync;

import java.util.concurrent.TimeUnit;

/**
 * Created by louyuting on 2017/6/6.
 */
public class ZookeeperTest {

    @Test
    public void createNodeSyncTest() throws Exception {
        CreateNodeSync client = new CreateNodeSync();
        client.connect();
        client.create("zoo-test", "value");
        client.close();
    }
    @Test
    public void createNodeAsyncTest() throws Exception {
        CreateNodeAsync client = new CreateNodeAsync();
        client.connect();
        client.create("zoo-test", "value");
        // 这里必须加一个延时，等待异步回调接口，或则这里也可以加一个闭锁或则 Condition类似的工具，确保回调接口已经被调用。
        TimeUnit.SECONDS.sleep(1);
        client.close();
    }
    @Test
    public void createNodeAsyncNTest() throws Exception {
        CreateNodeAsync client = new CreateNodeAsync();
        client.connect();
        client.create("zoo-test", "value");

        for(int i=0; i<20; i++){
            client.create("zoo-test/test"+i, "value"+i);
        }
        // 这里必须加一个延时，等待异步回调接口，或则这里也可以加一个闭锁或则 Condition类似的工具，确保回调接口已经被调用。
        TimeUnit.SECONDS.sleep(1);
        client.close();
    }
















}
