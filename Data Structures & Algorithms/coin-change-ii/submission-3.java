public class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        //Arrays.sort(coins); // Optional but safe if coins aren't sorted

        // dp[i][a] = number of ways to make amount 'a' using coins[i..]
        int[][] dp = new int[n + 1][amount + 1];

        // Base case: There is 1 way to make amount 0 — use no coins
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill dp table from bottom-up (from last coin back to first)
        for (int i = n - 1; i >= 0; i--) {
            for (int a = 0; a <= amount; a++) {
                dp[i][a] = dp[i + 1][a]; // Option 1: don't take coin[i]

                if (a >= coins[i]) {
                    // Option 2: take coin[i], stay at same i (since we can reuse)
                    dp[i][a] += dp[i][a - coins[i]];
                }
            }
        }

        // dp[0][amount] is number of ways to make amount using all coins
        return dp[0][amount];
    }
}
