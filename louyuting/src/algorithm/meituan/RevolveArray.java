package algorithm.meituan;

/**
 * Created by louyuting on 2017/2/15.
 * 旋转递增有序数组中出现的最小的数字，要求效率高，并分析
 *
 * 旋转数组的定义: 比如{3,4,5,1,1,1,1,1,2} 为{1,2,3,4,5}数组的一个旋转
 * 求旋转数组中的最小值.
 *
 * 特殊情况: 1) 旋转的长度为0 ,比如{1,2,3,4,5} 旋转为 {1,2,3,4,5}
 *          2) 存在重复的数字,比如{0,1,1,1,1,1} 旋转成{1,1,1,0,1,1}
 *
 * 分析特性: 将原数组a 拆分长b 和 c 也就是a = b + c, 而且c中的数据均小于等于b中数据;
 *
 *          a)先找到分割点,

 *
 */
public class RevolveArray {

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
