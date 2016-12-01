package leetcode.array;

import utils.LogUtil;

/**
 * Created by louyuting on 16/11/25.
 * 80. Remove Duplicates from Sorted Array II
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?
 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.


 */
public class Question80 {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }


    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        int result = removeDuplicates(nums);
        LogUtil.log_debug("" + result);
        for(int i=0; i<result; i++){
            LogUtil.log_debug(""+nums[i]);
        }
    }
}
