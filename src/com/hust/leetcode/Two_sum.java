package com.hust.leetcode;

public class Two_sum {	
		public int[] twoSum(int[] nums, int target) {
	        int result[] =new int[2];
	        for(int i=0;i<nums.length;i++)
	        {
	            for(int j=1;j<nums.length;j++)
	            {
	                if((nums[i]+nums[j])==target && (i!=j))
	                {
	                    result[0]=i;
	                    result[1]=j;
	                    return result;
	                }
	            }
	        }
	        return null;
	        
	    }
}
