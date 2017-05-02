package leetcode;

/**
 * Created by louyuting on 16/11/24.
 * 260. Single Number III
 Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 Find the two elements that appear only once.

 For netty.example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above netty.example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class Question260 {

    public static int[] singleNumber(int[] nums) {
        //遍历数组,看每个数据是否存在其余可以亦或为0的数据
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==0)
                continue;
            for (int j=i+1; j<nums.length; j++){
                if( (nums[i]^nums[j]) == 0 ) {
                    nums[i]=0;
                    nums[j]=0;
                    break;
                }
            }
        }

        //找出非0的两个数据
        int[] result = new int[2];
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                result[j++]=nums[i];
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int [] nums = {1, 2, 1, 3, 2, 5};
        int [] result = singleNumber(nums);
        for(int i: result){
            System.out.print(i+",");
        }
    }
}
