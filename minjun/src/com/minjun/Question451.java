package com.minjun;

import java.util.*;

/**
 * Created by zmjkey on 2017/5/14.
 */
public class Question451 {

    public String frequencySort(String s) {

        char str[] = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Map<Character , Integer> map = new HashMap<Character , Integer>();

        for(int i = 0; i<str.length ; i++){
            map.put( str[i] , map.containsKey(str[i]) ? (map.get(str[i])+1) : 1);
        }

        List<Map.Entry<Character , Integer>> list = new ArrayList<Map.Entry<Character , Integer>>(map.entrySet());
        Collections.sort( list , new Comparator<Map.Entry<Character , Integer>>(){

            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });

        for(Map.Entry<Character, Integer> mapping : list){
            for(int i = 0; i< mapping.getValue();i++){
                sb.append(mapping.getKey().toString());
            }
        }

//        for (int i = 0; i < list.size(); i++) {
//            for(int j = 0; j <list.get(i).getValue(); j++ ){
//                sb.append(list.get(i).getKey()) ;
//            }
//        }

        return sb.toString();
    }
}
