package algorithm.meituan;

import leetcode.common.TreeNode;

/**
 * Created by louyuting on 2017/2/15.
 * 求二叉树的深度:  递归实现
 */
public class BinaryTreeDeepth {

    public static int func(TreeNode root){

        if (root == null)
            return 0;

        //叶节点
        if(root.left == null && root.right == null){
            return 1;
        }

        //非叶节点
        return Math.max(func(root.left), func(root.right)) +1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.left.left =  new TreeNode(3);
        root.left.left.left.left =  new TreeNode(4);
        root.left.left.left.left.right =  new TreeNode(5);
        root.left.left.left.left.right.left =  new TreeNode(6);

        System.out.print(func(root));
    }




}
