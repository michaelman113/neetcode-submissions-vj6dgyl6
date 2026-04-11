public class Solution {
    // Memoization table: dp[i][j] stores if s[i:] matches p[j:]
    private Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        dp = new Boolean[m + 1][n + 1]; // use m+1, n+1 to allow base case of empty suffixes
        return dfs(0, 0, s, p, m, n);
    }

    private boolean dfs(int i, int j, String s, String p, int m, int n) {
        // If we reached the end of pattern, s must also be fully matched
        if (j == n) {
            return i == m;
        }

        // Check memoized value
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Check if s[i] matches p[j]
        boolean match = (i < m) && 
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // If next character in pattern is '*', we have two choices:
        if (j + 1 < n && p.charAt(j + 1) == '*') {
            // Option 1: skip this pattern segment (zero occurrence)
            // Option 2: use one match (if `match` is true), stay on j and advance i
            dp[i][j] = dfs(i, j + 2, s, p, m, n) || 
                       (match && dfs(i + 1, j, s, p, m, n));
        } else {
            // No '*', so we just try to match this char and move both pointers
            dp[i][j] = match && dfs(i + 1, j + 1, s, p, m, n);
        }

        return dp[i][j];
    }
}
