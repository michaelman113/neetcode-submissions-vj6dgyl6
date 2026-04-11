public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // We create a new array `newNums` with 2 extra elements at the ends (virtual balloons with value 1)
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1; // virtual balloons at both ends
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];  // shift original nums into the middle
        }

        // Initialize a DP table where dp[i][j] means:
        // max coins obtainable from bursting all balloons between i and j (exclusive)
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;  // mark as uncomputed
            }
        }

        // Call helper function to compute max coins in interval (1, n)
        // (since 0 and n+1 are the dummy boundaries)
        return dfs(newNums, 1, newNums.length - 2, dp);
    }

    // DFS with memoization
    public int dfs(int[] nums, int l, int r, int[][] dp) {
        if (l > r) {
            // Empty subarray, no coins
            return 0;
        }

        if (dp[l][r] != -1) {
            // Already computed subproblem
            return dp[l][r];
        }

        dp[l][r] = 0;

        // Try bursting each balloon `i` in the range [l, r] as the *last* one
        for (int i = l; i <= r; i++) {
            // When `i` is the last balloon to burst in range [l, r], the coins gained are:
            // nums[l-1] * nums[i] * nums[r+1] (because neighbors are not yet burst)
            // + recursively solving left and right subintervals
            int coins = nums[l - 1] * nums[i] * nums[r + 1];

            // Recursively solve the left and right partitions
            coins += dfs(nums, l, i - 1, dp); // left subproblem
            coins += dfs(nums, i + 1, r, dp); // right subproblem

            // Take the max over all choices of `i` as last balloon to burst
            dp[l][r] = Math.max(dp[l][r], coins);
        }

        return dp[l][r];
    }
}
