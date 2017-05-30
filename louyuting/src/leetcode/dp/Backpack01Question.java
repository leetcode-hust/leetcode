package leetcode.dp;

/**
 * @author louyuting
 * @create 2017-05-20-下午1:15
 *
 * 01背包问题。 有n个宝石和一个背包总容量是C。每个宝石的体积和价值分别是v[i]和w[i]，求在前n个宝石中找出数个宝石装入容量为体积C的背包中使总价值最大。
 * 实现函数是： int getMaxValue(int n, int c)
 *
 * 状态 d(i, j)  表示将前i个宝石装到剩余体积是j的背包中能达到的最大价值
 *
 * 状态转移方程是：d(i, j)=max{ d(i-1, j), d(i-1,j-V[i-1]) + W[i-1] }
 */
public class Backpack01Question {
    private static final int MAXN = 100;
    private static final int MAXC = 1000;

    private static int[] v = {5,  4,  3};// 前n个宝石中每个宝石的体积
    private static int[] w = {20, 10, 12};// 前n个宝石中每个宝石的价值

    private static int[][] d = new int[MAXN][MAXC] ;

    /**
     * 01背包问题
     * @param n 前n个宝石, 宝石的编号从0开始的
     * @param c 背包的最大容量
     * @return
     */
    public static int getMaxValue(int n, int c){
        for(int i=0; i<=n; i++){//前n个宝石的遍历
            for(int j=0; j<=c; j++){//体积的遍历
                //判断i是否为0， 如果i是0，就表示从前0个宝石中取出来，所以必定有d[i][j]为0
                //当i不为0的时候，先将d[i][j] 赋值为d[i-1][j]，也就是前i-1个宝石中取出装到容量为j 中的最大价值。
                d[i][j] = (i==0?0:d[i-1][j]);
                if(i>0 && j>=v[i-1]){// i>0 表示从前i个宝石里面取，j>=v[i-1]表示第i-1个宝石的体积小于等于剩余容量j，也就是还有容量装第i-1个宝石
                    d[i][j] = Math.max(d[i-1][j], d[i-1][j-v[i-1]] + w[i-1]);
                }
            }
            System.out.println("从前{" + i +"}个宝石中取宝石的最大价值是："+ d[i][c]);
        }
        System.out.println("最大价值是："+ d[n][c]);
        return d[n][c];
    }

    public static void main(String[] args) {
        Backpack01Question.getMaxValue(3, 10);
    }
}