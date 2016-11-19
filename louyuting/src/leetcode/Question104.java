package leetcode;

import leetcode.common.TreeNode;

/**
 * Created by louyuting on 16/11/20.
 * 求二叉树的最大深度
 * 104. Maximum Depth of Binary Tree
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Question104 {

    /**
     * 用递归做.
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.getLeft() == null && root.getRight()!= null){
            return maxDepth(root.getRight());
        } else if(root.getLeft() != null && root.getRight()== null){
            return maxDepth(root.getLeft());
        }else if(root.getLeft() == null && root.getRight()== null){
            return maxDepth(root);
        }

    }

    public static void main(String[] args) {

    }
}
