package distributed;

import java.util.*;

/**
 * Created by louyuting on 17/2/7.
 * 源地址 hash法
 */
public class HashIP {

    public static String getServerIP() {

        //重新在线程本地copy一份IPMap, 避免服务器上线下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IPMap.serverWeightMap);

        //取的IP地址的Set
        Set<String> ips = serverMap.keySet();

        List<String> iplist = new ArrayList<String>();
        iplist.addAll(ips);

        //获取IP的策略
        //获取远端请求的IP地址
        String remoteIP = "127.0.0.11";
        int hashCode = remoteIP.hashCode();
        hashCode = Math.abs(hashCode);//确保hash值是正数. 如果hash值是负数
        int ipSize = iplist.size();
        int pos = hashCode % ipSize;

        return iplist.get(pos);
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        String result = null;
        for(int i=0; i<10; i++){
            result = getServerIP();
            System.out.println("load balance 的地址是:" + result);
        }
    }
}
