package leetcode;

/**
 * Created by louyuting on 17/2/10.
 *
 */
public class Question96 {

    public static int numTrees(int n) {
        int [] f = new int[n+1];//利用f[n]来存储最后的结果.
        f[0] = f[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                f[i] += f[j-1] * f[i-j];
            }
        }
        return f[n];
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //
        System.out.println(Question96.numTrees(10));
    }
}
