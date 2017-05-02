package leetcode;

import org.junit.Test;
import utils.LogUtil;

import java.util.Arrays;

/**
 * Created by louyuting on 16/11/15.
 * 413- Arithmetic Slices
 *
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference
 * between any two consecutive elements is the same.

 For netty.example, these are arithmetic sequence:

 1, 3, 5, 7, 9
 7, 7, 7, 7
 3, -1, -5, -9
 The following sequence is not arithmetic.

 1, 1, 2, 5, 7

 A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q)
 such that 0 <= P < Q < N.

 A slice (P, Q) of array A is called arithmetic if the sequence:
 A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

 The function should return the number of arithmetic slices in the array A.


 Example:

 A = [1, 2, 3, 4]

 return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 *
 *
 */

/**
 * 1. 最开始用递归做的,但是一直显示 Time Limit Exceeded
 */
public class Question413_time_exceeded {

    public static int numberOfArithmeticSlices(int[] A) {
        if(A.length<3)
            return 0;

        if(A.length==3){
            if(judgeArithmetic(A)){
                return 1;
            }else{
                return 0;
            }
        }
        //当数组A的长度大于3时.
        if(judgeArithmetic(A)){
            return n_sum(A.length - 2);
        }else{
            //求A的下一层递归
            /*int[] A1 = new int[A.length-1];
            int[] A2 = new int[A.length-1];
            int[] A3 = new int[A.length-2];
            for(int i=0; i<A.length-1; i++){
                A1[i] = A[i];
            }
            for(int i=1; i<A.length; i++){
                A2[i-1] = A[i];
            }
            for(int i=1; i<A.length-1;i++){
                A3[i-1] = A[i];
            }*/
            //减去中间重复出现的
            return numberOfArithmeticSlices(Arrays.copyOfRange(A, 0, A.length-1))+numberOfArithmeticSlices(Arrays.copyOfRange(A, 1, A.length))-numberOfArithmeticSlices(Arrays.copyOfRange(A, 1, A.length-1));
        }
    }



    public static boolean judgeArithmetic(int[] A){
        if(A.length<3){
            return false;
        }
        int length = A.length;
        if((A[length-1]-A[0])%(length-1) != 0){//slice不是整数
            return false;
        }
        int slice = (A[length-1]-A[0])/(length-1);//差值
        for(int i=0; i<length-1;i++){
            if(A[i+1]-A[i] == slice){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }


    public static int n_sum(int n){
        int sum=0;
        for(int i=1; i<=n; i++){
            sum += i;
        }
        return sum;
    }

    @Test
    public void test(){
        int[]A = {1,2,3,4,8,9,10};


    }
    public static void main(String[] args) {

        int[] A = {1,2,3,4,8,9,10};

        int result = numberOfArithmeticSlices(A);

        LogUtil.log_debug("result: "+result);

    }
}
