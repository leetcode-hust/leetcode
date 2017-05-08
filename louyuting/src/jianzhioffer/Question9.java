package jianzhioffer;

/**
 * Created by louyuting on 2017/2/20.
 * 斐波拉契数列.
 *
 */
public class Question9 {

    //递归,  这种时间复杂度是非常高的, 存在大量的时间复杂度 2^n
    public static long Fibonacci(int n){
        if(n<=0){
            return 0;
        }

        if(n==1){
            return 1;
        }

        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    //非递归
    public static long Fibonacci2(int n){
        if(n<=0){
            return 0;
        }

        if(n==1){
            return 1;
        }

        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;

        for(int i=2; i<=n; i++){
            result[i] = result[i-2] + result[i-1];
        }

        return result[n];
    }

    //优化. 不占用O(n) 内存
    public static long Fibonacci3(int n){
        if(n<=0){
            return 0;
        }

        if(n==1){
            return 1;
        }

        int[] result = new int[2];
        result[0] = 0;
        result[1] = 1;

        int res=0;
        int one = result[0];
        int two = result[1];
        for(int i=2; i<=n; i++){
            res = one + two;
            one = two;
            two = res;
        }

        return res;
    }


    public static void main(String[] args) {

    }

}
