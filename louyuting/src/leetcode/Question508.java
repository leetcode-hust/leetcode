package leetcode;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by louyuting on 2017/5/9.
 */
public class Question508 {

    public static Map<Integer, Integer> map= new HashMap<>();

    public static void func(TreeNode root){

        if(root == null)
            return;;

        func(root.left);

        func(root.right);
    }

    public int[] findFrequentTreeSum(TreeNode root) {

        if(root == null)
            return new int[1];

        if(root.left == null && root.right == null){
            int[] res={root.val};
            return res;
        }




        return null;
    }
}
