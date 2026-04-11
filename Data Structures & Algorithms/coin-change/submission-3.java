class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int k = 0; k < coins.length; k++) {
            for (int i = 0; i <= amount; i++) {
                if (i - coins[k] >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i- coins[k]]);
                }
            }
        }
        return (dp[amount] == amount + 1? -1 : dp[amount]);
    }
}
