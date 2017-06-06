package zookeeper.zookeeper.main;

import org.apache.zookeeper.server.ZKDatabase;
import utils.LogUtil;
import zookeeper.zookeeper.watcher.NodeChildrenChangedWatcher;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by louyuting on 2017/6/6.
 *
 * 同步获取 子结点
 */
public class ListNodeSync extends ConnectionZookeeper{

    public void list(String nodeName) throws Exception{
        String path = "/" + nodeName;
        List<String> res = zk.getChildren(path, true);
        LogUtil.printList(res);
        create("zoo-test/test24", "value24");
        TimeUnit.MILLISECONDS.sleep(1000);
    }


    public static void main(String[] args) throws Exception {
        ListNodeSync listNodeSync = new ListNodeSync();

        listNodeSync.connect(new NodeChildrenChangedWatcher(listNodeSync.getLatch(), listNodeSync));

        listNodeSync.list("zoo-test");
    }
}
