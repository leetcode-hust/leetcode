package leetcode;

import utils.LogUtil;

/**
 * Created by louyuting on 16/11/17.
 */
public class Question136 {

    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,2,3,4,11,5,5,3,0,2,11};

        int result = singleNumber(nums);
        LogUtil.log_debug("" + result);
    }
}
