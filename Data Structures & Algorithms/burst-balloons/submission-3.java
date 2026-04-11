public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Create a new array with 1s padded at both ends for easier boundary handling
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        // dp[l][r] will hold the max coins obtainable from bursting balloons between l and r (inclusive)
        int[][] dp = new int[n + 2][n + 2];

        // Fill DP table in bottom-up manner
        // l goes from n to 1, and r from l to n — ensures subintervals are solved before bigger ones
        for (int len = 1; len <= n; len++) {
            for (int l = 1; l <= n - len + 1; l++) {
                int r = l + len - 1;
                for (int i = l; i <= r; i++) {
                    int coins = newNums[l - 1] * newNums[i] * newNums[r + 1] + dp[l][i - 1] + dp[i + 1][r];
                    dp[l][r] = Math.max(dp[l][r], coins);
                }
            }   
        }


        // Final result: max coins from bursting all balloons between 1 and n
        return dp[1][n];
    }
}
