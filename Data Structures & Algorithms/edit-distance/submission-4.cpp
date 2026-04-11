class Solution {
public:
    int minDistance(string word1, string word2) {
        //dp[i][k] = min number of operations to make word1 (0...i) equal to word2 (0...k)
        int m = word1.length();
        int n = word2.length();
        vector<vector<int>> dp(m+1, vector<int>(n+1));
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int l = 0; l <= m; l++) {
            dp[l][0] = l;
        }
        for (int i = 1; i <= m; i++) {
            for (int k = 1; k <= n; k++) {
                if (word1[i-1] == word2[k-1]) {
                    dp[i][k] = dp[i-1][k-1];
                } else {
                    int transition = min(dp[i][k-1], dp[i-1][k]);
                    dp[i][k] = 1 + min(transition, dp[i-1][k-1]);
                }
            }
        }
        return dp[m][n];
    }
};
