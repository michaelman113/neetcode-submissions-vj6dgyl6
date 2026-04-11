class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dpTable = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        return dp(0, 0, obstacleGrid, dpTable, m, n);
    }

    private int dp(int r, int c, int[][] obstacleGrid, int[][] dpTable, int m, int n) {
        if (r == m-1 && c == n-1) {
            return 1;
        }
        if (dpTable[r][c] != 0) {
            return dpTable[r][c];
        }
        if (r + 1 < m && obstacleGrid[r+1][c] != 1) {
            dpTable[r][c] += dp(r+1, c, obstacleGrid, dpTable, m, n);
        }
        if (c + 1 < n && obstacleGrid[r][c+1] != 1) {
            dpTable[r][c] += dp(r, c+1, obstacleGrid, dpTable, m, n);
        }
        return dpTable[r][c];
    }
}