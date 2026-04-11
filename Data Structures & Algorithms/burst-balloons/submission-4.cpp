class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<int> newNums(n + 2);
        newNums[0] = newNums[n+1] = 1;
        for (int i = 0; i < n; ++i) {
            newNums[i+1] = nums[i];
        }

        vector<vector<int>> dp (n+2, vector<int>(n+2));

        for (int len = 1; len <= n; len++) {
            for (int l = 1; l <= n - len + 1; l++) {
                int r = l + len - 1;
                for (int i = l; i <= r; i++) {
                    int coins = newNums[l - 1] * newNums[i] * newNums[r + 1] + dp[l][i - 1] + dp[i + 1][r];
                    dp[l][r] = max(dp[l][r], coins);
                }
            }   
        }
        return dp[1][n];

    }
};
