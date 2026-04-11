class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (dp[row][col] != 0) return dp[row][col];

        int maxLen = 1;
        for (int[] d : dirs) {
            int newR = row + d[0], newC = col + d[1];
            if (newR >= 0 && newR < matrix.length && newC >= 0 && newC < matrix[0].length &&
                matrix[newR][newC] > matrix[row][col]) {
                maxLen = Math.max(maxLen, 1 + dfs(matrix, newR, newC));
            }
        }
        dp[row][col] = maxLen;
        return maxLen;
    }
}
