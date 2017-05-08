package leetcode.test;

/**
 * Created by louyuting on 2017/2/14.
 */
public class Test {

    public static long ff(int n){
        if(n <=0)
            return 0;

        if(n ==1 )
            return 1;

        return ff(n-1) + ff(n-2);
    }


    public static void main(String[] args) {

        //System.out.println(""+ ff(100));

        System.out.println('9' - '0');

    }
}
