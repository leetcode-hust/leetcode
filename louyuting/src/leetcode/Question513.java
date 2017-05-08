package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by louyuting on 2017/5/3.
 *
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * 找到二叉树最后一层的最左边的结点的值:
 *      层次遍历到最后一层. 然后找到第一个节点。
 *
 */
public class Question513 {

    public static int levelView(TreeNode root){
        List<List<TreeNode>> list = new LinkedList<List<TreeNode>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelNum = queue.size();
            List<TreeNode> subList = new ArrayList<>();

            for(int i=0; i<levelNum; i++){

                TreeNode node = queue.poll();
                subList.add(node);

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }

            list.add(subList);
        }
        return list.get(list.size()-1).get(0).val;
    }

    public int findBottomLeftValue(TreeNode root) {
        if( root == null || (root.left==null && root.right==null) )
            return 0;

        return levelView(root);
    }
}
