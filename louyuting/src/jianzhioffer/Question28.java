package jianzhioffer;

/**
 * Created by louyuting on 2017/2/22.
 *
 * Question:
 */
public class Question28 {

    public static void func(String str){

        func1(str.toCharArray(), 0);

    }

    public static void func1(char[] str, int start){

        if(start == str.length-1){
            System.out.println(str);
        }
        else {
            for(int i= start; i<str.length; i++){

                //交换str[i] 和 str[start]
                char temp = str[i];
                str[i] = str[start];
                str[start] = temp;

                func1(str, (start + 1));

                //交换还原
                temp = str[i];
                str[i] = str[start];
                str[start] = temp;
            }
        }


    }


    public static void main(String[] args) {
        func("abc");
    }
}
