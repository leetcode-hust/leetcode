package leetcode;

import utils.LogUtil;

/**
 *
 */
public class Question75 {

    /**
     * 两轮遍历
     * @param nums
     */
    public static void sortColors1(int[] nums) {
        int num0, num1, num2;
        num0 = num1 = num2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                num0++;
            else if (nums[i] == 1)
                num1++;
            else if (nums[i] == 2)
                num2++;
        }

        int i=0;
        while (num0>0){
            nums[i++]=0;
            num0--;
        }
        while (num1>0){
            nums[i++]=1;
            num1--;
        }
        while (num2>0){
            nums[i++]=2;
            num2--;
        }
    }

    /**
     * 一轮遍历: 使用了两个索引 :
     * indexred 表示红色的索引 0
     * indexblue 表示蓝色的索引 2
     * 这两个索引分别从首尾向中间夹逼;
     *
     * 用i来从前往后遍历, 如果碰到0 就和indexred交换; 如果碰到2 就和indexblue交换.
     *
     * @param nums
     */
    public static void sortColors2(int[] nums) {

        int indexred = 0;
        int indexblue = nums.length-1;
        int temp;

        for (int i=0; i<=indexblue; i++){
            //只要nums[i]为2 就执行交换, 防止2,1,2 这种情况,这种情况下会不被排序
            while (nums[i] == 2 && i<indexblue){
                //将nums[i] 与 nums[indexblue] 交换
                temp = nums[i];
                nums[i] = nums[indexblue];
                nums[indexblue] = temp;
                indexblue--;
            }

            while(nums[i] == 0 && i>indexred){
                //将nums[i] 与 nums[indexred] 交换
                temp = nums[i];
                nums[i] = nums[indexred];
                nums[indexred] = temp;

                indexred++;
            }
        }
    }



    public static void main(String[] args) {
        int[] A = {2,1,2};

        sortColors2(A);

        for(int i=0; i<A.length; i++){
            LogUtil.log_debug(""+A[i]);
        }
    }
}
