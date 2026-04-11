class Solution {
public:
    int change(int amount, vector<int>& coins) {
        //dp[i][k] = number of ways to make amount i from coins[0....k]
        int n = coins.size();
        vector<vector<int>>dp(amount + 1, vector<int>(n+1, 0));
        for (int k = 0; k <= n; k++) {
            dp[0][k] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int k = 0; k < n; k++) {
                int diff = i - coins[k];
                if (diff >= 0) {
                    dp[i][k+1] = dp[i][k] + dp[diff][k+1];
                } else {
                    dp[i][k+1] = dp[i][k];
                }
            }
        }

        return dp[amount][n];
    }
};



//dp[1][1] = 1
//dp[1][2] = 1;
//dp[1][3] = 1;
//dp[2][1] = 1;
//dp[2][2] = 2;
//dp[2][3] = 2;
//dp[3][1] = 1;
//dp[3][2] = 2;
//dp[3][3] = 3;
//dp[4][1] = 1;
//dp[4][2] = 3;
//dp[4][3] = 4;
