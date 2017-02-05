package leetcode;

import utils.LogUtil;

/**
 * 这个是参考网上的:这个的思路是从3个连续的开始一直往上加.
 * 参考链接:
 * https://discuss.leetcode.com/topic/63302/simple-java-solution-9-lines-2ms
 */
public class Question413 {

    public static int numberOfArithmeticSlices(int[] A) {
        int curr=0;//每次计数的保存值
        int sum=0;//计数最后总的序列个数

        for(int i=2; i<A.length; i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                curr++;
                sum += curr;
            }else {
                curr=0;
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        int[] A = {1,2,3,4,8,9,10};
        int result = numberOfArithmeticSlices(A);
        LogUtil.log_debug("result: "+result);
    }
}
