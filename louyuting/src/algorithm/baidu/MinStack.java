package algorithm.baidu;

import java.util.Stack;

/**
 * Created by louyuting on 2017/2/27.
 * Question: 带min函数的栈以及辅助栈的优化
 *
 */
public class MinStack {

    public static Stack<Integer> stack = new Stack<Integer>();
    public static Stack<Integer> stack2 = new Stack<Integer>();


    //入栈
    public static void push(Integer num){
        stack.push(num);//元素入数据栈

        if(stack2.isEmpty()){
            stack2.push(num);
        }else {
            if(num >= stack2.lastElement()) {//num比辅助栈的数据大,就把辅助栈的数据复制一遍push
                stack2.push(stack2.lastElement());
            }
            else{
                stack2.push(num);
            }
        }
    }

    //出栈
    public static Integer pop(){
        stack2.pop();//删除辅助栈的栈顶
        return stack.pop();
    }

    //获取最小值
    public static Integer min(){
        return stack2.lastElement();
    }

    public static void main(String[] args) {
        MinStack.push(4);
        MinStack.push(5);
        MinStack.push(4);
        MinStack.push(5);
        MinStack.push(4);
        MinStack.push(1);
        MinStack.push(0);

        while (!stack.isEmpty()) {
            System.out.println("current max : " + MinStack.min());
            MinStack.pop();
        }
    }
}
