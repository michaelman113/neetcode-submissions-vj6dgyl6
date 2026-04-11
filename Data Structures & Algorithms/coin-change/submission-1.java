public class Solution {
    // Memoization map to store the minimum coins needed for a given amount
    HashMap<Integer, Integer> memo = new HashMap<>();

    // Recursive helper function to compute minimum coins needed to make up a given amount
    public int dfs(int amount, int[] coins) {
        // Base case: if amount is 0, no coins are needed
        if (amount == 0) return 0;

        // If we've already computed this amount, return the stored result
        if (memo.containsKey(amount)) 
            return memo.get(amount);

        // Initialize result to a very large value to simulate infinity
        int res = Integer.MAX_VALUE;

        // Try using each coin denomination
        for (int coin : coins) {
            // Only proceed if the coin can be subtracted from the amount
            if (amount - coin >= 0) {
                // Recursively compute the result for the remaining amount
                int result = dfs(amount - coin, coins);

                // If the result is not infinity, update the minimum coins needed
                if (result != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + result); // +1 for the current coin used
                }
            }
        }
        
        // Store the computed result in the memoization map
        memo.put(amount, res);

        // Return the minimum number of coins needed (or infinity if not possible)
        return res;
    }

    // Main function to compute coin change
    public int coinChange(int[] coins, int amount) {
        int minCoins = dfs(amount, coins);

        // If no combination was found, return -1
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
}
