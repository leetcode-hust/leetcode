package algorithm.ali;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static boolean resolve(int[] A) {

        if(A==null || A.length <7)
            return false;

        //定义两个个index
        int i=0;
        int j=A.length-1;
        //自定义三个变量, suml 和 sumr分别表示两边的和, suma表示最后的结果和
        int suma=0, suml=0, sumr=0;

        //初值
        suml += A[i];
        sumr += A[j];

        while (i < j){
            //左边index自加
            if(suml < sumr){
                i++;
                suml += A[i];
            } else if(suml > sumr){//由边index自加
                j--;
                sumr += A[j];
            } else {// suml==sumr
                //切换到新的区间再次判断
                i++;
                j--;
                if(j-i >4 ){
                    suma = suml;
                    suml = sumr = 0;

                    suml += A[i];
                    sumr += A[j];
                } else if(j-i==4){
                    if(A[i+1] == A[j-1]){
                        return true;
                    }
                } else if(j-i==2){
                    if(suma == suml){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while(line != null && !line.isEmpty()) {
            int value = Integer.parseInt(line.trim());
            if(value == 0) break;
            inputs.add(value);
            line = in.nextLine();
        }
        int[] A = new int[inputs.size()];
        for(int i=0; i<inputs.size(); i++) {
            A[i] = inputs.get(i).intValue();
        }
        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}
