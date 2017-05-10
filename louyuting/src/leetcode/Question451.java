package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author louyuting
 * @create 2017-05-09-下午7:35
 */
public class Question451 {
    //空间换时间， hash表实现
    public String frequencySort(String s) {
        if(s == null)
            return null;

        // K:V 表示 字符: 字符出现的次数
        Map<Character, Integer> map = new HashMap<>();

        for(Character c : s.toCharArray()){
            map.put(c, map.get(c)==null? 1 : map.get(c)+1);
        }

        int[] a = new int[map.size()];
        int i=0;
        for(char c : map.keySet())
            a[i++] = map.get(c);

        // 将Map中的数据转换到treeMap中， K:V 表示频度:出现相同次数的单链表。
        TreeMap<Integer, List<Character>> treeMap = new TreeMap<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            // 如果当前entry的value也就是频度为null, 也就是当前频度的字符还不存在
            if(treeMap.get(entry.getValue()) == null){
                List<Character> list = new LinkedList<>();
                list.add(entry.getKey());
                treeMap.put(entry.getValue(), list);
            }else {
                //如果当前entry的value也就是频度不为null, 也就是当前频度的字符已经存在，就先取出value的链表再插入
                List<Character> value = treeMap.get(entry.getValue());
                value.add(entry.getKey());
                treeMap.put(entry.getValue(), value);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (treeMap.size()>0){
            List<Character> last  = treeMap.get(treeMap.lastKey());
            for (Character c : last){
                int count = treeMap.lastKey();
                while(count >0){
                    sb.append(c);
                    count--;
                }
            }
            treeMap.remove(treeMap.lastKey());
        }
        return sb.toString();
    }
}
