package jianzhioffer;

/**
 * Created by louyuting on 2017/2/20.
 * 二进制中1的个数
 */
public class Question10 {

    public static int NumberOf1(int n) {
        int count = 0;

        while (n > 0){
            if(n % 2 == 1){
                count++;
            }
            n = n/2;
        }
        return count;
    }


    public static void main(String[] args) {

    }




}
