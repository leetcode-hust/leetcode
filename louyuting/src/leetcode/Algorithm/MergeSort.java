package leetcode.Algorithm;

/**
 * Created by louyuting on 17/2/6.
 */
public class MergeSort {

    /**
     * 把有序数组a和有序数组b 合并到数组c中
     * @param a
     * @param n 数组a的长度n
     * @param b
     * @param m 数组b的长度m
     * @param c
     */
    private void memergeArray(int a[], int n, int b[], int m, int c[]){
        int i,j,k;

        i=j=k=0;

        while (i < n && j < m){
            if(a[i] < b[j]){
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i<n){
            c[k++] = a[i++];
        }

        while (j < m){
            c[k++] = b[j++];
        }
    }//end


    /**
     * 将a[first, mid] 和 a[mid+1, last] 合并
     * @param a
     * @param first
     * @param mid
     * @param last
     * @param temp
     */
    private static void mergeArray(int a[], int first, int mid, int last, int temp[]){
        int i = first, j=mid+1;//设置两个数组的起始边界
        int m=mid, n=last;//设置两个数组的结束边界

        int k=0;

        while (i <= m && j<=n){
            if(a[i] <= a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }

        while (i<=m){
            temp[k++] = a[i++];
        }

        while (j < n){
            temp[k++] = a[j++];
        }

        for(i=0; i<k; i++){
            a[first+i] = temp[i];
        }
    }

    /**
     * 二路归并  使用递归解决.
     * @param a
     * @param first 数组的其实下标
     * @param last 数组的结束下标
     * @param temp 辅助数组
     */
    public static void mergeSort(int[] a, int first, int last, int[] temp){
        if(first < last) {
            int mid = (first + last)/2;

            mergeSort(a, first, mid, temp);//左边有序
            mergeSort(a, mid+1, last, temp);//右边有序

            mergeArray(a, first, mid, last, temp); //再将两个有序序列合并.
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,9,3,12,7,8,3,4,65,22};
        int[] temp = {0,0,0,0,0,0,0,0,0,0};


        mergeSort(arr, 0, arr.length-1, temp);

        for(int i:arr){
            System.out.print(i+",");
        }
    }


}
