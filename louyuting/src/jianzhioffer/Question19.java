package jianzhioffer;

import leetcode.common.TreeNode;

/**
 * Created by louyuting on 2017/2/22.
 *  19:二叉树的镜像
 */
public class Question19 {

    public static void Mirror(TreeNode root) {
        if(root == null)
            return;

        if(root.left == null && root.right==null)
            return;

        //先序遍历解决: 根左右
        TreeNode temp=null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(8);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        Mirror(root);
    }

}
