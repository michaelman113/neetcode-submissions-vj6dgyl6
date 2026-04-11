class Solution {
public:
    int minDistance(string word1, string word2) {
        int m = word1.length(), n = word2.length();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        //dp[m][n] = min operations to make word1[...m] equal to word2][...n]
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int k = 0; k <= n; k++) {
            dp[0][k] = k;
        }
        for (int i = 1; i <= m; i++) {
            for (int k = 1; k <= n; k++) {
                if (word1[i-1] == word2[k-1]) {
                    dp[i][k] = dp[i-1][k-1];
                } else {
                    int transition = min(dp[i-1][k], dp[i][k-1]);
                    dp[i][k] = 1 + min(transition, dp[i-1][k-1]);
                }
            }
        }
        return dp[m][n];
    }
};