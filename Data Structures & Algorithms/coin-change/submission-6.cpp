class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        //dp[i] = min amount of coins to reach amount i
        int n = coins.size();
        vector<int> dp(amount+1, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int k = 0; k < n; k++) {
                if (i - coins[k] >= 0) {
                    dp[i] = min(dp[i], 1 + dp[i - coins[k]]);
                }
            }
        }
        //[1, ]
        return (dp[amount] >= (amount + 1) ? -1 : dp[amount]);
    }
};

//dp[i] = min(dp[i], 1 + dp[i - coins[k]]);
//base case (dp[0] = 1;)