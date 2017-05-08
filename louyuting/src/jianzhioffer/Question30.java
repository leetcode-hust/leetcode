package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by louyuting on 2017/2/22.
 *
 * Question:30 求最小的k个数
 */
public class Question30 {

    //最常见的就是先排序了,时间复杂度是O(nlogn) ,

    //优化: 这里只要求最小的k个数,并不要求这k个数是有序的, 可以利用快速排序的特点, 利用快排. 知道排序到 索引是k-1的地方
    //      时间复杂度就是O(n)


    // 对于海量的数据来说, 可以用 k 大小的数组, 存着k个数, 每次取数就和这k个数中的最大值,比较, 如果大就不处理, 如果小,就替换最大值.
    //z这里一个重点就是关于维护k个元素的数组的最大值, 用最大堆,但是实际上笔试不可能写出最大堆代码,所以可以用红黑树实现.
    // 时间复杂度就是 O(nlogk)


    //这里基于第二种方式, 快排实现
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        if(input==null || input.length==0){
            return res;
        }

        //一次快速排序,获得 index 位置
        int start=0;
        int end = input.length-1;
        int index = partition(input, start, end);

        while (index != k-1){
            if(index < k-1){
                start = index+1;
                index = partition(input, start, end);
            } else {
                end = index-1;
                index = partition(input, start, end);
            }
        }

        //全部加入lisy
        for(int i=0; i<=k-1; i++)
            res.add(input[i]);

        return res;
    }

    public static int partition(int []array,int lo,int hi){
        /** 固定的切分方式 */
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }


    public static void main(String[] args) {

    }
}
