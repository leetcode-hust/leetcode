package leetcode;

import utils.InputUtil;
import utils.LogUtil;

/**
 * Created by louyuting on 16/11/18.
 *
 * 371: Sum of Two Integers
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.

 Credits:
 */
public class Question371 {

    public static void main(String[] args) {
        int a = InputUtil.inputInt("请输入a:");
        int b = InputUtil.inputInt("请输入b:");

        while( (a&b) != 0){//判断当前a和b相加时是否需要进位:如果还要进位近进入循环否则退出循环.
            int temp1 = a&b; //与算法,求出要进位的位;
            temp1 = temp1<<1;//左移一位表示进位.
            int temp2 = a^b;//亦或求出不需要进位的数据和
            a = temp1;
            b = temp2;
        }
        int result = a|b;
        LogUtil.log_debug(""+result);
    }
}
