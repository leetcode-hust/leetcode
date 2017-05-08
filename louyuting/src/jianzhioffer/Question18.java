package jianzhioffer;

import leetcode.common.TreeNode;

/**
 * Created by louyuting on 2017/2/22.
 *  18:树的子结构
 */
public class Question18{

    /**
     * 二叉树的递归遍历
     * @param root1
     * @param root2
     * @return
     */
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;
        if (root1!=null && root2!= null){
            if(root1.val == root2.val){
                result =  check(root1, root2);
            }

            if(!result){
                result = HasSubtree(root1.left, root2);
            }
            if(!result){
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public static boolean check(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        //root2 非空
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return check(root1.left, root2.left) && check(root1.right, root2.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(8);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println( HasSubtree(root, root2) );
    }

}
