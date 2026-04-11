public class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] = minimum number of coins needed to make amount i
        int[] dp = new int[amount + 1];
        
        // Initialize with a value greater than any possible answer
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins needed to make amount 0
        dp[0] = 0;

        // Build up dp from 1 to amount
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // If coin value is usable for current amount
                if (coins[j] <= i) {
                    // Try taking coin[j], see if it leads to a better answer
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // If no solution found, return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
