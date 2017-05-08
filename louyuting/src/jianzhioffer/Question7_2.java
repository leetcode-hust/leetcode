package jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by louyuting on 2017/2/20.
 * 面试题7-- 用两个队列实现栈
 */
public class Question7_2 {
    private static Queue<Integer> queue1 = new LinkedList<>();//入队
    private static Queue<Integer> queue2 = new LinkedList<Integer>();//出队

    //入栈
    public static void push(int node) {

        if(queue1.isEmpty()){
            queue2.offer(node);
        }else {
            queue1.offer(node);
        }
    }

    //出栈
    public static Integer pop() {
        if(queue1.isEmpty()){
            //队列1为null
            //从队列2中取出
            while (queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }else if (queue2.isEmpty()){
            //队列1为null
            //从队列2中取出
            while (queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else {
            return null;
        }
    }


    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            Question7_2.push(i);
        }
        for(int i=0; i<5; i++){
            System.out.println(Question7_2.pop());
        }

        for(int i=5; i<10; i++){
            Question7_2.push(i);
        }
        for(int i=5; i<10; i++){
            System.out.println(Question7_2.pop());
        }
    }


}
