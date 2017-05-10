package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.common.TreeNode;

public class Question508{
    public Map<Integer, Integer> map= new HashMap<>();

    /**
     * 递归求每个节点的subtree sum，并存入map,对于重复的用 hash 来保存重复出现的次数
     * 这里从叶节点开始算，避免了重复计算。
     */
    public int func(TreeNode root){
        if(root == null)
            return 0;;

        int left  = func(root.left);
        int right = func(root.right);

        int sum = left+right+root.val;
        map.put(sum, map.get(sum)==null? 1: map.get(sum)+1);
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {

        if(root == null)
            return new int[0];

        if(root.left == null && root.right == null){
            int[] res={root.val};
            return res;
        }

        func(root);

        int max=0;
        for(int key : map.keySet()){
            max = map.get(key)>max? map.get(key):max;
        }

        List<Integer> reslist = new ArrayList<Integer>();
        for(int key : map.keySet()){
            if(map.get(key) == max){
                reslist.add(key);
            }
        }
        int[] res = new int[reslist.size()];
        for (int i=0; i<res.length; i++){
            res[i] = reslist.get(i);
        }
        return res;
    }
}