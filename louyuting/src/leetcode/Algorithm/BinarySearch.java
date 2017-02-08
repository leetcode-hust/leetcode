package leetcode.Algorithm;

/**
 * Created by louyuting on 17/2/8.
 * 二分查找的 递归与非递归实现
 */
public class BinarySearch {
    /**
     * 非递归方式查找
     * @param array
     * @param a
     * @return 查找到的索引值
     */
    public static int binarySearch1(int[] array, int a){
        int lo=0, hi=array.length-1;

        int mid;//中间索引

        while (lo <= hi){
            mid = (lo+hi)/2;

            if(array[mid] == a){
                return mid;
            } else if(array[mid] < a){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return -1;
    }

    /**
     * 递归方式查找
     * @param array
     * @param a
     * @return
     */
    public static int binarySearch2(int[] array, int a, int lo, int hi){
        if(lo <= hi){
            int mid = (lo+hi)/2 ;

            if( a == array[mid] ){
                return mid;
            } else if(a > array[mid]){
                return binarySearch2(array, a, mid+1, hi);
            } else {
                return binarySearch2(array, a, lo, mid-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,1,2,3,3,4,7,8,9,12,22,65};

        int result = BinarySearch.binarySearch2(arr, 3, 0, (arr.length-1) );

        System.out.print(result);
    }

}
