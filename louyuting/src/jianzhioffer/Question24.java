package jianzhioffer;

/**
 * Created by louyuting on 2017/2/22.
 *
 * Question:24 二叉搜索树的后续遍历序列: 输入一个整数数组,判断该数组是不是某二叉搜索树的后序遍历的结果, 如果是就返回true, 否则返回false.
 *              假设数组中任意两个数字都互不相同.
 */
public class Question24 {

    public static boolean func(int[] sequence){

        if(sequence == null || sequence.length==0)
            return false;

        return func1(sequence, 0, sequence.length - 1);
    }


    public static boolean func1(int[] a, int start, int end){
        if(start > end || start<0 || end >=a.length)
            new Exception("start和end 参数不正确");

        if(start==end)
            return true;

        //获取根节点:
        int root = a[end];
        //找到左右子树的分割点
        int index=0;
        for(index=start; index<end; index++){
            if(a[index] < root)
                continue;
            else {
                break;
            }
        }
        //index可能等于end, 这时只有左子树,没有右子树
        if(index == end){
            //先校验
            for(int i = start; i<end; i++){
                if(a[i] < root)
                    continue;
                else
                    return false;
            }
            return func1(a, start, end-1);
        }

        //index等于 start, 这时候只有右子树,没有左子树
        if(index == start){
            //先校验
            for(int i = start; i<end; i++){
                if(a[i] > root)
                    continue;
                else
                    return false;
            }
            return func1(a, start, end-1);
        }

        //此时 [start, index-1]是左子树, [index, end]是右子树, 左子树已经不必判断了,现在判断右子树
        for(int i = index; i<end; i++){
            if(a[i] > root)
                continue;
            else
                return false;
        }
        return func1(a, start, index - 1) && func1(a, index, end - 1);

    }

    public static void main(String[] args) {
        int[] a = {7,4,6,5};
        System.out.println(func(a) );
    }
}
