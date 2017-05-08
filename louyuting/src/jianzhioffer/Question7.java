package jianzhioffer;

import java.util.Stack;

/**
 * Created by louyuting on 2017/2/20.
 * 面试题7-- 用两个栈实现队列
 */
public class Question7 {
    private static Stack<Integer> stack1 = new Stack<Integer>();//入队
    private static Stack<Integer> stack2 = new Stack<Integer>();//出队

    //入队
    public static void push(int node) {
        stack1.push(node);

    }

    //出队
    public static int pop() {
        //1. 首先判断栈2中是否为空
        if(stack2.isEmpty()){
            //栈1中的数据全部入栈2
            if(stack1.isEmpty()){
                //栈1也是空的,就说明队列为null
                new Exception("队列空了");
            }
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();

        }else {
            return stack2.pop();
        }
    }


    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            Question7.push(i);
        }
        for(int i=0; i<10; i++){
            System.out.println(Question7.pop());
        }
    }


}
