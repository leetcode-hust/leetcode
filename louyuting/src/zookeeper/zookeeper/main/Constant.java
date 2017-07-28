package zookeeper.zookeeper.main;


/**
 * Created by louyuting on 2017/6/6.
 */
public class Constant {
    public static final int ResultCode_OK = 0;
    public static final int ResultCode_ConnectionLoss = -4;
    public static final int ResultCode_NodeExists = -110;
    public static final int ResultCode_SessionExpired = -112;

    //zookeeper 的主机
    public static final String HOST1 = "123.206.13.151:2181";

    // session 会话超时时间，毫秒为单位，
    public static final int SESSION_TIMEOUT = 5000;

    //
}
