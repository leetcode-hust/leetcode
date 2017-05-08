package algorithm.Algorithm;

/**
 * Created by louyuting on 17/2/8.
 * 桶排序
 */
public class BucketSort {

    public static int[] bucketSort(int[] nums, int maxNum){
        int[] sorted = new int[maxNum+1];

        for(int i=0; i<nums.length; i++){
            sorted[nums[i]] = nums[i];//把数据放到对应索引的位置
        }
        return sorted;
    }


    public static void main(String[] args) {
        int[] x = { 99, 65, 24, 47, 50, 88,33, 66, 67, 31, 18 };
        int[] sorted = bucketSort(x, 99);
        for (int i = 0; i < sorted.length; i++)
        {
            if (sorted[i] > 0)
                System.out.print(sorted[i]+", ");
        }
    }
}
