package zookeeper.zookeeper.asynccallback;

import org.apache.zookeeper.AsyncCallback;
import utils.LogUtil;

/**
 * Created by louyuting on 2017/6/6.
 *
 * 字符串数据回调
 */
public class StringCallbackImpl implements AsyncCallback.StringCallback {
    /**
     * @param rc 服务端响应码
     * @param path 数据节点路径参数
     * @param ctx
     * @param name
     */
    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        LogUtil.log_debug("create path result:[" + rc + ", " + path +
                ", "+ ctx +", real path name: " + name);
    }
}
