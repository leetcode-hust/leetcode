package algorithm.baidu;

import java.util.Stack;

/**
 * Created by louyuting on 2017/2/27.
 * Question: 带min函数的栈 的 辅助栈的优化
 */
public class MinStack2 {

    public static Stack<Integer> stack = new Stack<Integer>();
    public static Stack<Integer> stack2 = new Stack<Integer>();


    //入栈优化
    public static void push(Integer num){
        stack.push(num);//元素入数据栈

        if(stack2.isEmpty()){
            stack2.push(num);
        }else {
            //1. 如果入栈数据num比辅助栈的栈顶的数据大, 辅助栈就不必入栈,避免内存浪费
            if(num > stack2.lastElement()) {
                //
            }
            else{//2. 如果入栈数据num比辅助栈的栈顶的数据小或则等于, 辅助栈就入栈,
                stack2.push(num);
            }
        }
    }

    //出栈
    public static Integer pop(){
        int result = stack.pop();

        //如果栈中是最后一个元素了,辅助栈肯定要同步出栈
        if(stack.size()==1)
            stack2.pop();//删除辅助栈的栈顶
        else {
            //出栈数据等于出栈后的栈顶数据, 辅助栈出站
            if(result == stack2.lastElement()) {
                stack2.pop();
            } else if(result > stack2.lastElement()){
                //不管
            }
        }
        return result;
    }

    //获取最小值
    public static Integer min(){
        return stack2.lastElement();
    }

    public static void main(String[] args) {
        MinStack2.push(1);
        MinStack2.push(0);
        MinStack2.push(1);
        MinStack2.push(0);
        MinStack2.push(1);
        MinStack2.push(0);
        MinStack2.push(1);

        while (!stack.isEmpty()) {
            System.out.println("current max : " + MinStack2.min());
            MinStack2.pop();
        }
    }
}
