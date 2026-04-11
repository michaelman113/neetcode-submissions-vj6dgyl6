class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int k = 1; k <= n; k++) {
                if (text1.charAt(i-1) == (text2.charAt(k-1))) {
                    dp[i][k] = dp[i-1][k-1] + 1;
                } else {
                    dp[i][k] = Math.max(dp[i][k-1], dp[i-1][k]);
                }
            }
        }
        return dp[m][n];
    }
}
