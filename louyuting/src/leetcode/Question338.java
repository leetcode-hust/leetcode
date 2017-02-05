package leetcode;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by louyuting on 16/11/15.
 * 338-Counting Bits
  Question: Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
  calculate the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:
 1.It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 2.Space complexity should be O(n).
 3.Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 */
public class Question338 {

    private static int[] countBits(int num){
        Stack<Integer> values = new Stack<Integer>();//用栈来保存num的二进制之后的每一位数据
        int[] result = new int[num+1];//保存最后的结果
        result[0]=0;//当num为0时,结果直接是0

        int count=0;
        for(int i=1; i<=num; i++){
            int item = i;//取出0-num的每一项

            //对item取余入栈,然后再对2取整
            while(item>0){
                values.push(item%2);//对2取余的值入栈
                item = item/2;
            }
            //遍历栈里面的每一项,统计1的个数
            for(int value: values){
                if(value==1){
                    count++;
                }
            }
            //将结果计入result中,并清零count
            result[i]=count;
            count=0;
            values.clear();//栈清空
        }

        return result;
    }

    @Test
    public void test(){
        int[] result = countBits(9);
        for(int i: result){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入num:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int num = Integer.valueOf(input);

        int[] result = countBits(num);
        System.out.print("[");
        for(int i: result){
            System.out.print(i+",");
        }
        System.out.print("]");
    }
}
