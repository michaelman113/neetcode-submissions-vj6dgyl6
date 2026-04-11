class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return dp(0, 0, dp, m, n);
    }

    private int dp(int r, int c, int[][] dp, int m, int n) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        if (r == m-1 && c == n-1) {
            return 1;
        }
        if (r + 1 < m) {
            dp[r][c] += dp(r+1,c,dp,m,n);
        }
        if (c + 1 < n) {
            dp[r][c] += dp(r,c+1,dp,m,n);
        }
        return dp[r][c];
    }
}
