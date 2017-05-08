package jianzhioffer;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by louyuting on 2017/2/22.
 *
 * Question:23 从上到下打印二叉树, 同一层次按照从左到右.
 */
public class Question23 {

    public static ArrayList<Integer> func(TreeNode root){
        //solution: 利用层次遍历 + 队列实现;

        if(root == null)
            return null;
        ArrayList<Integer> res = new ArrayList<>();
        //队列实现
        Queue<TreeNode> queue = new LinkedList<>();

        int[] level = new int[100];
        int count=0;

        //根入队
        queue.offer(root);

        while (!queue.isEmpty()){
            //统计每层的结点数
            int size = queue.size();
            level[count++] = size;

            for(int i=0; i<size; i++){
                TreeNode temp = queue.poll();
                res.add(temp.val);
                //左结点入队
                if(temp.left != null)
                    queue.offer(temp.left);
                //右结点入队
                if(temp.right != null)
                    queue.offer(temp.right);
            }
        }

        System.out.println("总有多少层:"+ (count-1) );

        for(int i=0; i<count; i++){
            System.out.println(level[i]);
        }

        System.out.println("树的输出打印");
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(8);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        func(root);
    }
}
