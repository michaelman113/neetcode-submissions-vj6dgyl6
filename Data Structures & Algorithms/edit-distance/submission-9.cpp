class Solution {
public:
    int minDistance(string word1, string word2) {
        //time complexity = O(m*n) m = word1.length, n = word2.length
        int m = word1.length(), n = word2.length();
        //dp[i][k] =min operations to change substring [0....i] to substring [0.....k]
        vector<vector<int>> dp(m+1, vector<int>(n+1, INT_MAX));
        for (int i = 0; i <= n; i++) {
            dp[0][i] = min(dp[0][i], i);
        }
        for (int k = 0; k <= m; k++) {
            dp[k][0] = min(dp[k][0], k);
        }
        for (int l = 1; l <= m; l++) {
            for (int r = 1; r <= n; r++) {
                if (word1[l - 1] == word2[r - 1]) {
                    dp[l][r] = dp[l-1][r-1];
                } else {
                    int transition = min(dp[l-1][r], dp[l][r-1]);
                    int finalTrans = min(transition, dp[l-1][r-1]);
                    dp[l][r] = finalTrans + 1;
                }
            }
        }
        return dp[m][n];
    }

    //monkeys money
    //
};
