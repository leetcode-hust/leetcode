package com.minjun;

import java.util.*;

/**
 * Created by zhao_mj on 2017/5/11.
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Question508 {

    int value = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int max,length;

        //ºóÐò±éÀú
        postOrder(root);


        max = 0;  length = 0;
        for( int key : map.keySet()){
            max = map.get(key) > max ? map.get(key) : max;
        }

        for(int key : map.keySet()){
           if(max == map.get(key)){
               length++;
               list.add(key);
           }
        }

        int a[] = new int[length];
        for(int i = 0;i < length ;i++){
            a[i] = list.get(i);
        }

        return a;
    }

    public int postOrder(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        value = root.val+left+right;
        map.put(value , map.containsKey(value) ? (map.get(value)+1) : 1);
        return value;
    }
}