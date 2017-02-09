package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question94 {
    /**
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<Integer>();
        inHelper(root, res);
        return res;
    }

    private static void inHelper(TreeNode root, List<Integer> in) {
        if(root==null) return;
        inHelper(root.left, in);
        in.add(root.val);
        inHelper(root.right,in);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> resu = Question94.inorderTraversal(root);

        for (int i : resu){
            System.out.println(i);
        }
    }
}
