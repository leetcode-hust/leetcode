package leetcode;

/**
 * Created by louyuting on 17/2/8.
 */
public class Question35 {


    public static int searchInsert(int[] nums, int target) {

        for(int i=0; i<nums.length; i++){

            //找到就直接返回index
            if(nums[i] == target ){
                return i;
            }

            if(nums[i] < target && i< (nums.length-1) && nums[i+1] > target){
                return i+1;
            }

            if(nums[i] < target && i==(nums.length-1)){
                return nums.length;
            }
        }

        //当nums[0]都比target大时
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 7, 8, 9, 12, 22, 65};
        System.out.print( Question35.searchInsert(arr, 44)) ;
    }

}
