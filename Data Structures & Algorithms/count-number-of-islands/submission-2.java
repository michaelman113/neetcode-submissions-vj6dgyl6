class Solution {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1},{0, -1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[0].length; k++) {
                if (grid[i][k] == '1') {
                    count++;
                    dfs(grid, i, k);
                }
            }
        }
        return count;
    }


    private static void dfs(char[][] grid, int r, int c) {
        grid[r][c] = 0;
        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == '1') {
                dfs(grid, newR, newC);
            }
        }
    }
}
