package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.common.TreeNode;

/**
 * Created by louyuting on 2017/5/9.
 */
public class Question508 {

    public static Map<Integer, Integer> map= new HashMap<>();

    public static int func(TreeNode root){
        if(root == null)
            return 0;;

        int left  = func(root.left);
        int right = func(root.right);

        int sum = left+right+root.val;
        map.put(sum, map.get(sum)==null? 1: map.get(sum)+1);
        return sum;
    }

    public static int[] findFrequentTreeSum(TreeNode root) {

        if(root == null)
            return new int[1];

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);

        for(int i: findFrequentTreeSum(root)){
            System.out.println(i);
        }
    }
}
