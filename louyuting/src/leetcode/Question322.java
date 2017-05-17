package leetcode;

/**
 * @author louyuting
 * @create 2017-05-17-下午12:19
 */
public class Question322 {

    public int coinChange(int[] coins, int amount) {
        // 健壮性
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;

        int[] minNumber = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            minNumber[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE)
                    minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
            }
        }
        if (minNumber[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return minNumber[amount];
    }

    public static void main(String[] args) {
        Question322 question = new Question322();
        int[] coins = {1,3,5};
        System.out.println(question.coinChange(coins, 11));
    }
}
