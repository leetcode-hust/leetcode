package com.minjun;

import java.util.*;

/**
 * Created by zhao_mj on 2017/5/15.
 */
public class Question347 {
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i<nums.length ; i++){
            map.put(nums[i], map.containsKey(nums[i]) ? (map.get(nums[i])+1) : 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(int i = 0; i < k; i++){
            result.add(list.get(i).getKey());
        }
        return result;
    }

}
