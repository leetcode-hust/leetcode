package leetcode;

/**
 * @author louyuting
 * @create 2017-05-11-上午9:05
 */
public class Question238 {

    // 时间复杂度是 O(n), 空间复杂度是O(n)
    public int[] productExceptSelf(int[] nums) {
        if(nums == null)
            return null;

        if(nums.length == 0){
            return nums;
        }

        //倒叙乘积和
        int[] post = new int[nums.length];
        post[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            post[i] = post[i+1]*nums[i];
        }

        //正序乘积和
        int[] pre = new int[nums.length];
        pre[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            pre[i] = pre[i-1]*nums[i];
        }

        //nums[i]= pre[i-1] * post[i+1];
        nums[0] = post[1];
        nums[nums.length-1] = pre[nums.length-2];
        for(int i=1; i<nums.length-1; i++){
            nums[i]= pre[i-1] * post[i+1];
        }
        return nums;
    }

}
