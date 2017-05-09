package leetcode;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by louyuting on 2017/5/9.
 */
public class Question508 {

    public static Map<Integer, Integer> map= new HashMap<>();

    public static Integer sum=0;

    public static int func(TreeNode root){

        if(root == null)
            return 0;;

        int left = func(root.left);

        int right = func(root.right);

        sum = root.val + left + right;

        map.put(sum, map.get(sum)!=null? map.get(sum)+1 : 1);
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {

        if(root == null)
            return new int[1];

        if(root.left == null && root.right == null){
            int[] res={root.val};
            return res;
        }

        func(root);
        return null;
    }
}
