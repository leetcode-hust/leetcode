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
        //int i = nums.length>0?1 :0;
        if(nums.length<3){
            return nums.length;
        }
        int i=0;
        int j=2;
        for(i=2;i<nums.length; i++){
            if(nums[i]== nums[i-1] && nums[i-1] == nums[i-2]){
                continue;
            }else{
                nums[j++] = nums[i];
            }
        }
        return j;
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
