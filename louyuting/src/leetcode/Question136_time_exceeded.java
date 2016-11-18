package leetcode;

import utils.LogUtil;

/**
 * Created by louyuting on 16/11/17.
 * 136-Single Number
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 *
 */
public class Question136_time_exceeded {

    public static int singleNumber(int[] nums) {
        if(nums.length==0)
            return 0;
        else if(nums.length==1)
            return nums[0];

        int index = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] == index){
                break;
            }
            if(i==nums.length-1 && nums[nums.length] != index){
                return index;
            }
        }

        for(int i=0; i<nums.length;i++)
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    nums[i]=index;
                    nums[j]=index;
                }
            }

        for(int i=1; i<nums.length; i++){
            if(nums[i] != index)
                return nums[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,2,3,4,11,5,5,3,0,2,11};

        int result = singleNumber(nums);
        LogUtil.log_debug(""+result);
    }
}
