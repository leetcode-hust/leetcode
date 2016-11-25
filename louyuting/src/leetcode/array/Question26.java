package leetcode.array;

import utils.LogUtil;

/**
 * Created by louyuting on 16/11/25.
 * 26. Remove Duplicates from Sorted Array
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */
public class Question26 {
    public static int removeDuplicates(int[] nums) {
        int count=0;
        int result = nums.length;
        //int temp = nums[0]-1;
        int temp = Integer.MAX_VALUE;

        for(int i=0; i<nums.length-1; i++){
            if( (nums[i] ^ nums[i+1])==0 ){//存在相同的数字
                result--;
                nums[i] = temp;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] == temp){
                count++;
            }else{
                nums[i-count] = nums[i];
            }
        }
        return result;
    }


    public static int removeDuplicates2(int[] nums) {
        /*int index=0;
        for(int i=0; i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){

            }else{
                nums[index++] = nums[i];
            }
        }
        nums[index++] = nums[nums.length-1];
        return index;*/
        //首先做一个判断,nums的长度是否为0,如果为0直接就返回0
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)//迭代每个数据,然后判断
            if (n > nums[i - 1])
                nums[i++] = n;
        return i;
}


    public static void main(String[] args) {
        int [] nums = {1,1,2};
        int result = removeDuplicates2(nums);
        LogUtil.log_debug("" + result);
        for(int i=0; i<result; i++){
            LogUtil.log_debug(""+nums[i]);
        }
    }
}
