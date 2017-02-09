package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question99 {
    /**
     * @param root
     * @return
     */
    public static void recoverTree(TreeNode root) {
        //获取结点的中序排序
        List<TreeNode> res= new ArrayList<TreeNode>();
        inHelper(root, res);

        //将中序序列存入数组中
        TreeNode[] array = new TreeNode[res.size()];
        int i=0;
        for (TreeNode r : res){
            array[i++] = r;
        }

        //找到错误的两个元素的下标
        int low, hi;
        hi = low = 0;
        for(i=0; i<array.length; i++ ){
            if( i < array.length-1 && array[i].val > array[i+1].val){
                low = i;
                break;
            }
        }
        for(i=array.length-1; i>=0; i-- ){
            if( i >0  && array[i].val < array[i-1].val){
                hi = i;
                break;
            }
        }

        //将数组中两个结点的 value交换
        int temp=0;
        temp = array[low].val;
        array[low].val = array[hi].val;
        array[hi].val = temp;

        /*for (TreeNode ss : array){
            System.out.println(ss.val);
        }*/
    }

    /**
     * 中序排序
     * @param root
     * @param in
     */
    private static void inHelper(TreeNode root, List<TreeNode> in) {
        if(root==null) return;
        inHelper(root.left, in);
        in.add(root);
        inHelper(root.right,in);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(23);

        Question99.recoverTree(root);

    }
}
