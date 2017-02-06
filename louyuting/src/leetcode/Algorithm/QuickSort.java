package leetcode.Algorithm;

/**
 * Created by louyuting on 17/2/5.
 * 快速排序
 */
public class QuickSort {
    /**
     * 一次快速排序
     * @param array 数组
     * @param lo 数组的前下标
     * @param hi 数组的后下标
     * @return key的下标index
     */
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


    /**
     * 快速排序
     * @param array
     * @param lo
     * @param hi
     */
    public static void quickSort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        //排序前半部分
        quickSort(array, lo, index - 1);
        //排序后半部分
        quickSort(array,index+1,hi);
    }


    public static void main(String[] args) {
        int[] arr = {1,9,3,12,7,8,3,4,65,22};

        quickSort(arr, 0, arr.length-1);

        for(int i:arr){
            System.out.print(i+",");
        }
    }
}
