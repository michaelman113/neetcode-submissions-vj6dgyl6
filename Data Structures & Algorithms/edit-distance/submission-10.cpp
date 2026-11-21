class Solution {
public:
    int minDistance(string word1, string word2) {
        //dp (I hate this)
        //dp[i][k] = min number of operations to make word1.subst(0....i) equal to word2.subst(0.....k)
        int m = word1.size(), n = word2.size();
        vector<vector<int>>dp(m+1, vector<int>(n+1, 0));
        //base case = if we're just adding from empty string to another, it just takes x characters from the nonempty string we want to match
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int k = 0; k <= n; k++) {
            dp[0][k] = k;
        }
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                if (word1[r-1] == word2[c-1]) {
                    //cout << word1[r-1] << word2[c-1] << '\n';
                    dp[r][c] = dp[r-1][c-1]; //if characters are the same 
                } else {
                    int falseMin = min(dp[r-1][c], dp[r][c-1]);
                    int trueMin = 1 + min(falseMin, dp[r-1][c-1]);
                    dp[r][c] = trueMin;
                    //insert, subtract, or replace
                }
            }
        }
        return dp[m][n];
    }
};

//
//
//
//