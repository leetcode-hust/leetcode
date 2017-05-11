package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author louyuting
 * @create 2017-05-11-上午8:33
 */
public class Question347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        /**
         * 1. 首先用一个 hashMap 表存储每个数字出现的次数
         * 2. 然后用 TreeMap 存储出现相同次数的数字链表，注意TreeMap底层是红黑树，对Key实现里有序。
         * 3. 输出前k 个平频率的数字。
         */

        // 对k 和 nums 做检查
        if(nums == null)
            return null;

        List<Integer> res = new LinkedList<>();

        Map<Integer, Integer> frequentMap = new HashMap<>();
        for(int num : nums){
            frequentMap.put(num, frequentMap.get(num)==null?1: (frequentMap.get(num)+1));
        }

        // key是频率， value是出现相同频率的链表
        SortedMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
        for(Map.Entry<Integer, Integer> entry : frequentMap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            //如果当前 value 频率的 数字还没有出现过
            if(sortedMap.get(value)==null){
                List<Integer> list = new LinkedList<>();
                list.add(key);
                sortedMap.put(value, list);
            } else {
                List<Integer> list = sortedMap.get(value);
                if (list == null){
                    try {
                        throw new Exception("list is null");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                list.add(key);
                sortedMap.put(value, list);
            }
        }

        while (k > 0){
            // 获取最大的频率对应的数字链表
            List<Integer> list = sortedMap.get( sortedMap.lastKey() );
            sortedMap.remove(sortedMap.lastKey());

            for(int num : list){
                res.add(num);
                k--;
                if (k <= 0)
                    break;
            }
        }

        return res;
    }


    public static void main(String[] args) {

    }




}
