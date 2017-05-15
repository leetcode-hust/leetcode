package com.minjun;

/**
 * Created by zmjkey on 2017/5/14.
 */
public class Question238 {

    public int[] productExceptSelf(int[] nums) {
        int result = 1;
        int zeroSize = 0; int zeroNum = 0;
        int output[] = new int[nums.length];
        for(int i = 0; i< nums.length ; i++){
            if(nums[i] == 0){
                zeroSize ++;
                zeroNum = i;
                nums[i] = 1;
            }
            result *= nums[i];
        }

        if(zeroSize >= 2){
            for(int i = 0; i< nums.length ; i++){
                output[i] = 0;
            }
        }else if(zeroSize == 1){
            for(int i = 0; i< nums.length ; i++){
                if(i == zeroNum){
                    output[i] = result;
                    i++;
                }
               if(i< nums.length){
                    output[i] = 0;
                }
            }
        }else {
            for(int i = 0; i< nums.length ; i++){
                output[i] = result/nums[i];
            }
        }
        return output;
    }
}