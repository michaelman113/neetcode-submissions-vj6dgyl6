class Solution {
    public int numIslands(char[][] grid) {
        // Your solution here
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (grid[i][k] == '1') {
                    count++;
                    dfs(i, k, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, char[][] grid) {
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        grid[r][c] = '0';
        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length) {
                if (grid[newR][newC] == '1') {
                    dfs(newR, newC, grid);
                }
            }
        }
    }
}