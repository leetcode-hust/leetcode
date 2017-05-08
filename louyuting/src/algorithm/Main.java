package algorithm;

import java.util.Scanner;

/**
 * Created by louyuting on 2017/3/9.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int sum=75;
        //对 n 个丹药 分别进行计算增加的经验值,并加入综合
        for (int i=0; i<n; i++){
            int count = sum/200;
            sum += Math.pow(2.0, count) * 3;
        }
        //输出等级
        System.out.println("result:" + (sum/200 + 1 ));

    }
}
