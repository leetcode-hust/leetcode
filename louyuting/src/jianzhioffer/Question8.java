package jianzhioffer;

/**
 * Created by louyuting on 2017/2/20.
 * 旋转数组; 直观的就是一轮遍历 时间复杂度是O(n)
 *         现在利用二分查找,时间复杂度是O(logn)
 */
public class Question8 {

    public static Integer func(int[] a, int start, int end){

        //鲁棒性
        if(a == null || a.length==0 || start<0 || end>=a.length || start>end){
            new Exception("error");
            return null;
        }

        //本身就是有序
        if(a[end] > a[start]){

            return a[start];
        }
        // 特殊情况2
        if(a[end] == a[start]){
            int i = end;
            while (i>start){
                if(a[i] < a[i-1]){
                    return a[i];
                }
                i--;
            }
            return a[i];
        }

        int lo = start;
        int hi = end;
        //利用二分查找
        int mid = (lo+hi)/2;

        if(a[mid] >= a[lo]){//说明结果在右边序列
            return func(a, mid+1, end);
        }else if(a[mid] < a[lo]){//结果在左边
            return func(a, start, mid);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] s  = {1,2,3};

        System.out.println(func(s, 0, s.length-1));
    }

}
