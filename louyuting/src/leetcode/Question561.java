package leetcode;

import java.util.Arrays;

/**
 * Created by louyuting on 2017/5/2.
 *
 * 561. Array Partition I
 */
public class Question561 {

    public static int func(int[] nums) throws Exception {
        if(nums == null || nums.length == 0 || nums.length%2 != 0)
            throw new Exception("nums 不符合规定");

        //对 nums数组进行排序
        Arrays.sort(nums);

        int result = 0;
        for(int i=0; i<nums.length; i=i+2){
            result += nums[i];
        }

        return result;
    }


    public static void main(String[] args) {

    }
}
