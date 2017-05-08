package algorithm.Algorithm;

import org.junit.Test;

/**
 * Created by louyuting on 17/2/6.
 * 冒泡排序的三种实现:
 */
public class BubbleSort {

    //交换a 和 b
    public void swap(Integer a, Integer b){
        Integer temp;
        temp = a;
        a = b;
        b = temp;
    }
    @Test
    public void test(){
        int a =1;
        int b =2;
        swap(a,b);
        System.out.print("a="+a +"  b="+b);
    }

    /**
     * 冒泡排序的第一种实现, 没有任何优化
     * @param a
     * @param n
     */
    public static void bubbleSort1(int [] a, int n){
        int i, j;

        for(i=0; i<n; i++){//表示n此循环遍历
            for(j=1; j<n-i; j++){
                if(a[j-1] > a[j]){//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j]=temp;
                }
            }
        }
    }// end


    /**
     * 设置一个标志，如果这一趟发生了交换，则为true，否则为false。明显如果有一趟没有发生交换，说明排序已经完成。
     * @param a
     * @param n
     */
    public static void bubbleSort2(int [] a, int n){
        int j, k = n;
        boolean flag = true;//发生了交换就为true, 没发生就为false

        while (flag){
            flag=false;
            for(j=1; j<k; j++){
                if(a[j-1] > a[j]){//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j]=temp;

                    //表示交换过数据;
                    flag = true;
                }
            }
            k--;
        }//end while
    }//end

    /**
     * 如果有100个数的数组，仅前面10个无序，后面90个都已排好序且都大于前面10个数字，
     * 那么在第一趟遍历后，最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，
     * 这时我们用一个变量记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
     *
     * 这种算法是目前想到的最优的冒泡排序了.
     * @param a
     * @param n
     */
    public static void bubbleSort3(int [] a, int n){
        int j , k;
        int flag = n ;//flag来记录最后交换的位置

        while (flag > 0){
            k = flag; //k 来记录 遍历的尾边界
            flag = 0;

            for(j=1; j<k; j++){
                if(a[j-1] > a[j]){//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j]=temp;

                    //表示交换过数据;
                    flag = j;//记录最新的尾边界.
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,0,9,3,12,7,8,3,4,65,22};

        BubbleSort.bubbleSort3(arr, arr.length);

        for(int i:arr){
            System.out.print(i+",");
        }
    }

}
