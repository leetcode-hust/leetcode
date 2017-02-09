package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question144 {
    /**
     * 用递归实现先序遍历: 根->左->右
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<Integer>();
        preHelper(root,pre);
        return pre;
    }

    private static void preHelper(TreeNode root, List<Integer> pre) {
        if(root==null) return;
        pre.add(root.val);
        preHelper(root.left,pre);
        preHelper(root.right,pre);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        List<Integer> resu = Question144.preorderTraversal(root);

        for (int i : resu){
            System.out.println(i);
        }
    }
}
