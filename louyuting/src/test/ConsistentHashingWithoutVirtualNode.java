package test;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by louyuting on 17/1/6.
 */
public class ConsistentHashingWithoutVirtualNode {

    private static String[] servers = {"192.168.0.0:8011","192.168.0.1:8011","192.168.0.2:8011","192.168.0.3:8011","192.168.0.4:8011"};

    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    static {
        for(int i=0; i<servers.length; i++){
            int hash = getHash(servers[i]);
            System.out.println("[" + servers[i] + "]加入集合中, 其Hash值为" + hash);
            sortedMap.put(hash, servers[i]);
        }
        System.out.println();
    }

    private static int getHash(String str)
    {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    private static String getServer(String node){
        //d得到hash值
        int hash = getHash(node);
        //得到大于该hash的map
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        //取第一个元素
        int i =subMap.firstKey();
        return subMap.get(i);
    }

    public static void main(String[] args) {
        String[] nodes = {"127.122.0.0:8011","11.168.22.1:8011","11.22.0.2:8011"};

        for (int i=0; i<nodes.length; i++){
            System.out.println("[" + nodes[i] + "]的hash值为" + getHash(nodes[i]) + ", 被路由到结点[" + getServer(nodes[i]) + "]");
        }

    }
}
