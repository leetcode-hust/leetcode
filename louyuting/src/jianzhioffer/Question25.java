package jianzhioffer;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by louyuting on 2017/2/22.
 *
 * Question: 二叉树中和为某一值的路径.  给定一颗二叉树 和 一个整数值, 打印出二叉树中节点值的和为给定值的所有路径.
 *              从根节点开始往下到叶节点经过的结点形成一条路径.
 */
public class Question25 {


    public static ArrayList<ArrayList<Integer>> func(TreeNode root, int target){
        //利用先序遍历 和 栈 实现,  栈里面就保存着路径.
        Stack<Integer> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        func1(root, stack, target, res);

        return res;
    }


    //
    public static void func1(TreeNode root, Stack<Integer> stack, int target, ArrayList<ArrayList<Integer>> res){
        //利用先序遍历 和 栈 实现, 栈里面就保存着路径.
        if(root== null)
            return;

        //叶结点就判断,
        if(root.left == null && root.right==null){
            stack.push(root.val);
            int sum = 0;
            //迭代数据
           Iterator<Integer> iterator = stack.iterator();
            while (iterator.hasNext()){
                sum += iterator.next();
            }
            //保存路径
            if(sum == target){
                //保存数据
                ArrayList<Integer> list = new ArrayList<>();
                Iterator<Integer> iterator2 = stack.iterator();
                while (iterator2.hasNext()){
                    list.add(iterator2.next());
                }
                res.add(list);
            }
        }else{
            //非叶节点就入栈
            stack.push(root.val);
        }

        //递归左子树
        func1(root.left, stack, target, res);
        //递归右子树
        func1(root.right, stack, target, res);

        /**返回父结点之前,在路径上删除当前结点*/
        stack.pop();

    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        System.out.print(func(root, 22));

    }
}
