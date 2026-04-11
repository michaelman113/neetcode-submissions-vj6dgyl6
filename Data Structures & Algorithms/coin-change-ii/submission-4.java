public class Solution {
public int change(int amount, int[] coins) {
    int n = coins.length;
    int[][] dp = new int[n + 1][amount + 1];

    // Base case: 1 way to make amount 0 with any number of coins
    for (int i = 0; i <= n; i++) {
        dp[i][0] = 1;
    }

    for (int i = 1; i <= n; i++) {
        int coin = coins[i - 1];
        for (int j = 0; j <= amount; j++) {
            dp[i][j] = dp[i - 1][j]; // don't use the coin
            if (j >= coin) {
                dp[i][j] += dp[i][j - coin]; // use the coin
            }
        }
    }

    return dp[n][amount];
}

}
