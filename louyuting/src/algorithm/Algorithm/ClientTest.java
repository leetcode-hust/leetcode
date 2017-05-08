package algorithm.Algorithm;

import java.util.Random;

/**
 * Created by louyuting on 17/2/6.
 */
public class ClientTest {
    private  static final int N = 8000;

    public static void main(String[] args) {
        int[] ns = new int[N];

        Random random = new Random();
        for(int i=0; i<ns.length; i++){
            ns[i] = random.nextInt(100000);
        }
        //测试排序算法
        long start = System.currentTimeMillis();
        BubbleSort.bubbleSort3(ns, ns.length);
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序的时间是:" + (end-start));



        for(int i=0; i<ns.length; i++){
            ns[i] = random.nextInt(100000);
        }
        //测试排序算法
        start = System.currentTimeMillis();
        InsertionSort.insertSort1(ns, ns.length);
        end = System.currentTimeMillis();
        System.out.println("直接插入排序的时间是:" + (end-start));



        for(int i=0; i<ns.length; i++){
            ns[i] = random.nextInt(100000);
        }
        //测试排序算法
        start = System.currentTimeMillis();
        QuickSort.quickSort(ns, 0, ns.length-1);
        end = System.currentTimeMillis();
        System.out.println("快速排序的时间是:" + (end-start));


        for(int i=0; i<ns.length; i++){
            ns[i] = random.nextInt(100000);
        }
        //测试排序算法
        int[] temp = new int[N];
        start = System.currentTimeMillis();
        MergeSort.mergeSort(ns, 0, ns.length-1, temp);
        end = System.currentTimeMillis();
        System.out.println("归并排序的时间是:" + (end-start));

    }


}
