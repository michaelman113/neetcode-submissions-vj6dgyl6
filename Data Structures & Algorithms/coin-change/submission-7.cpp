class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        //dp[i] = min number of coins needed to make up amount
        vector<int> dp(amount + 1, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int k = 0; k < n; k++) {
                if (i - coins[k] >= 0) {
                    dp[i] = min(dp[i], dp[i - coins[k]] + 1);
                }
            }
        }
        return (dp[amount] >= amount + 1 ? -1 : dp[amount]);
    }
};
