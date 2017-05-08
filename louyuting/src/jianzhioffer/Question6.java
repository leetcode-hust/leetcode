package jianzhioffer;

import leetcode.common.TreeNode;

/**
 * Created by louyuting on 2017/2/20.
 * 面试题6-- 重建二叉树: 给定某二叉树的前序遍历和中序遍历.重建该二叉树, 假设二叉树中不包含重复的数字.
 */
public class Question6 {
    /**
     *
     */
    public static TreeNode func1(int [] pre,int [] in){

        if(pre.length==0 || in.length==0 || pre==null || in==null)
            return null;

        //递归开始遍历
        return func(pre, 0, pre.length-1, in, 0, in.length-1);
    }


    /**
     *
     * @param pre 前序
     * @param pstart 前序起始下标
     * @param pend 前序结束下标
     * @param in 中序
     * @param istart 中序起始下标
     * @param iend 中序结束下标
     * @return
     */
    public static TreeNode func(int[] pre, int pstart, int pend, int[] in, int istart, int iend ){
        //先找到根节点
        TreeNode root = new TreeNode(pre[pstart]);

        //当pstart== pend 时表示只有一个节点了
        if(pstart == pend)
            return root;
        if(pstart > pend || istart>iend){
            return null;
        }

        //根据根节点到中序中找下标
        int mid=0;
        for(mid=istart; mid<=iend; mid++){
            if(in[mid] == root.val)
                break;
        }

        //找到了下标,求出左子树的长度 和 右子树长度
        int  left = mid-istart;
        int right = iend-mid;

        if(left>0){
            root.left =  func(pre, pstart+1, pstart+left, in, istart, mid-1);
        }else {
            root.left=null;
        }

        if(right>0){
            root.right = func(pre, pstart+left+1, pend, in, mid+1, iend);
        }else {
            root.right=null;
        }

        return root;
    }


    public static void main(String[] args) {

        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode r = func1(pre, in);
        printIN(r);

    }

    public static void printIN(TreeNode root){
        if(root !=null){
            printIN(root.left);
            System.out.println(root.val);
            printIN(root.right);
        }
    }


}
