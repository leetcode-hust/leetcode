package leetcode;

/**
 * Created by louyuting on 2017/5/2.
 */
public class Question461 {


    public static int func(int x, int y){
        int result = x ^ y;
        int count=0;
        for (int i=0; i<32 ;i++){
            if(result %2 == 0){//最低为不为1
                result = result >> 1;
            } else {
                count++;
                result = result >> 1;
            }
        }
        return count;
    }
}
