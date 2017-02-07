package distributed;

import java.util.HashMap;

/**
 * Created by louyuting on 17/2/7.
 */
public class IPMap {

    public static HashMap<String, Integer> serverWeightMap = new HashMap<String, Integer>();

    static {
        //第一个参数是IP地址,第二个是权重.
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.101", 2);
        serverWeightMap.put("192.168.1.102", 3);
        serverWeightMap.put("192.168.1.103", 4);
        serverWeightMap.put("192.168.1.104", 3);
        serverWeightMap.put("192.168.1.105", 2);
        serverWeightMap.put("192.168.1.106", 1);
        serverWeightMap.put("192.168.1.107", 2);
        serverWeightMap.put("192.168.1.108", 1);
        serverWeightMap.put("192.168.1.109", 4);
    }
}
