package leetcode;

import utils.InputUtil;
import utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by louyuting on 16/11/15.

 Write a program that outputs the string representation of numbers from 1 to n.

 But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 3的倍数输出 Fizz
 5的倍数输出 Buzz
 即是3的倍数也是5的倍数输出 FizzBuzz


 Example:

 n = 15,

 Return:
 [
 "1",
 "2",
 "Fizz",
 "4",
 "Buzz",
 "Fizz",
 "7",
 "8",
 "Fizz",
 "Buzz",
 "11",
 "Fizz",
 "13",
 "14",
 "FizzBuzz"
 ]



 */
public class Question412 {

    public static List<String> fizzBuzz(int num) {
        List<String> result = new ArrayList<String>();

        for(int i=1; i<=num; i++){
            if(i%3 == 0 && i%5 != 0){
                result.add("Fizz");
            }else if(i%3 != 0 && i%5 == 0){
                result.add("Buzz");
            }else if(i%3 == 0 && i%5 == 0){
                result.add("FizzBuzz");
            }else{
                result.add(new Integer(i).toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int num = InputUtil.inputInt("输入整数:");

        List<String> result = fizzBuzz(num);

        LogUtil.printList(result);

    }
}
