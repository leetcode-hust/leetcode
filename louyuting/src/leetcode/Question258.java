package leetcode;

import org.junit.Test;
import utils.LogUtil;

/**
 * Created by louyuting on 16/11/20.
 *
 * 258. Add Digits 数字的每位求和,直至结果为个位数
 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For netty.example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?
 */
public class Question258 {

    /**
     * 这个是最普通的算法,不停循环求出每位的和.
     * @By 娄宇庭
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        if(num<10)
            return num;
        int result = num;

        while (result>=10){
            int temp = 0;
            //将待求的多位数先转换成字符串再转换成字符数组;
            char[] numStrs = new Integer(result).toString().toCharArray();
            //遍历字符数组,获取每个字符数组代表的数,然后相加
            for(int i=0; i<numStrs.length; i++){
                temp += Integer.valueOf(String.valueOf(numStrs[i]));
            }
            result = temp;
        }
        return result;
    }


    /**
     * 参考网上别人的思路:  https://discuss.leetcode.com/topic/21588/1-line-java-solution
     * 大天朝算法真是厉害了..
     *  1行解决..
     *  思路:
     *      netty.example: 比如438
     *      438  ==  40*10 + 3*10 +8
     *      4+3+8 == 4*(10%9)*(10%9) + 3*(10%9) + 8%9=15
     *
     *      15 == 1*10 +5
     *      1+5 == 1*(10%9)+5%9 =6
     *
     *      规律: ab%9%9%9 == ab%9;
     * @param num
     * @return
     */
    public static int addDigits_reference(int num) {
        return num==0?0:(num%9==0?9: num%9);
    }



    public static void main(String[] args) {
        LogUtil.log_debug(""+addDigits_reference(38));
    }





    @Test
    public void test(){
        LogUtil.log_debug(""+ (int)Math.pow(10, 3));
        char i = '1';
        LogUtil.log_debug(""+ Integer.valueOf(String.valueOf(i)) );
    }
}
